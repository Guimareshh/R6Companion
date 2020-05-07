package com.guimaraes.lucien.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    private var list: List<News> = listOf()

    fun setUsers(items: List<News>) {
        list = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : NewsItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_news,
            parent,
            false
        )

        return NewsItemViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.newsTitle.text = list[position].title
        holder.newsContent.text = list[position].content
    }

    inner class NewsItemViewHolder(view: View) : ViewHolder(view) {
        val newsTitle: TextView = view.findViewById(R.id.item_news_title)
        val newsContent: TextView = view.findViewById(R.id.item_news_content)
    }
}