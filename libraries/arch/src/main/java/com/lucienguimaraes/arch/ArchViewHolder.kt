package com.lucienguimaraes.arch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.*

abstract class ArchViewHolder<V : View, IN : Any, OUT : Any>(
    private val rootView: ViewGroup,
    resId: Int,
    mainCoroutineDispatcher: MainCoroutineDispatcher
) : View.OnAttachStateChangeListener {

    private val contentView: V

    lateinit var inputs: IN
    lateinit var outputs: OUT

    protected val context : Context
        get() = contentView.context


    private val job = Job()
    private val uiScope = CoroutineScope(job + mainCoroutineDispatcher)

    init {
        contentView = inflate(rootView.context, rootView, resId)
        initView()
    }

    private fun inflate(
        context: Context,
        rootView: ViewGroup,
        resId: Int
    ): V {
        val view = LayoutInflater.from(context).inflate(resId, rootView, false)
        try {
            @Suppress("UNCHECKED_CAST")
            return view as V
        } catch (exception: ClassCastException) {
            throw  Exception("Bad layout type found in your xml file\nfoundClass:${view.javaClass}")
        }
    }

    private fun initView() {
        contentView.addOnAttachStateChangeListener(this)
    }

    fun showOnRootView() = apply {
        val rootView = this.rootView
        when (contentView.parent) {
            rootView -> {
            }
            null -> rootView.addView(contentView)
        }
    }

    fun dismissFromRootView() = apply {
        (contentView.parent as? ViewGroup)?.removeView(contentView)
    }

    protected fun <V : View> findViewById(resId: Int): V = contentView.findViewById(resId) as V


    protected abstract fun setUpView()
    protected abstract suspend fun  bindOutputs()


    override fun onViewAttachedToWindow(v: View) {
        setUpView()
        uiScope.launch {
            bindOutputs()
        }
    }

    override fun onViewDetachedFromWindow(v: View) {
        job.cancel()
    }
}