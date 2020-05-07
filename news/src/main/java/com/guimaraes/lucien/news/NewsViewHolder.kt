package com.guimaraes.lucien.news

import android.util.Log
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.lucienguimaraes.arch.ArchViewHolder
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.flow.collect

class NewsViewHolder(
    rootView: ViewGroup,
    mainCoroutineDispatcher: MainCoroutineDispatcher
) : ArchViewHolder<ConstraintLayout, NewsInputs, NewsOutputs>(
    rootView,
    R.layout.layout_news_list,
    mainCoroutineDispatcher
) {

    override fun setUpView() {
    }

    override suspend fun bindOutputs() {

        outputs.newsList.collect { it.forEach { news -> Log.d("news", news.title) } }

        outputs.errorMessage.collect { Log.d("news", it) }

    }
}