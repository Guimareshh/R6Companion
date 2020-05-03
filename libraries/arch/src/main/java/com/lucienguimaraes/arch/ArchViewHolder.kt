package com.lucienguimaraes.arch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class ArchViewHolder<V : View, VM : ArchViewModel, IN : Any, OUT : Any>(
    private val rootView: ViewGroup,
    resId: Int
) :
    View.OnAttachStateChangeListener {

    private val contentView: V

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


    protected abstract fun bindOutputs()

    fun showOnRootView() = apply {
        when (contentView.parent) {
            rootView -> rootView.bringChildToFront(contentView)
            null ->  when(contentView.parent) {
                rootView -> { }
                null -> rootView.addView(contentView)
            }
        }
    }

    fun dismissFromRootView() = apply {
        (contentView.parent as? ViewGroup)?.removeView(contentView)
    }


    override fun onViewAttachedToWindow(v: View) {
        bindOutputs()
    }

    override fun onViewDetachedFromWindow(v: View) {
        TODO("Not yet implemented")
    }
}