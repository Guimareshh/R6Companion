package com.guimaraes.lucien.news

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun requestNewsList(): Flow<List<News>> = flow {
        emit(newsApi.getNewsList())
    }
}

interface NewsRepository {
    fun requestNewsList(): Flow<List<News>>
}
