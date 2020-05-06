package com.guimaraes.lucien.home

import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.lucienguimaraes.arch.ArchViewHolder
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.flow.collect

class HomeViewHolder(
    rootView: ViewGroup,
    mainCoroutineDispatcher: MainCoroutineDispatcher
) : ArchViewHolder<ConstraintLayout, HomeInputs, HomeOutputs>(
    rootView,
    R.layout.layout_home,
    mainCoroutineDispatcher
) {

    private val title = findViewById<TextView>(R.id.title)

    override fun setUpView() {
    }

    override suspend fun bindOutputs() {

        outputs.users.collect { it.forEach { repo -> Log.d("repo", repo.name) } }

        outputs.title.collect { title.text = it }
    }

}