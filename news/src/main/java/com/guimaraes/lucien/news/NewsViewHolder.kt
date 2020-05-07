package com.guimaraes.lucien.news

import android.util.Log
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucienguimaraes.arch.ArchViewHolder
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.flow.collect

class NewsViewHolder(
    rootView: ViewGroup,
    private val newsAdapter: NewsAdapter,
    mainCoroutineDispatcher: MainCoroutineDispatcher
) : ArchViewHolder<ConstraintLayout, NewsInputs, NewsOutputs>(
    rootView,
    R.layout.layout_news_list,
    mainCoroutineDispatcher
) {

    private val newsListView = findViewById<RecyclerView>(R.id.news_list)

    override fun setUpView() {
        newsListView.layoutManager = LinearLayoutManager(context)
        newsListView.adapter = newsAdapter
    }

    override suspend fun bindOutputs() {

        outputs.newsList.collect {
            newsAdapter.setNewsList(it)
        }

        outputs.errorMessage.collect { Log.d("news", it) }
    }
}