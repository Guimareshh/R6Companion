package com.guimaraes.lucien.news

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map

class NewsViewModel(
    newsInteractor: NewsInteractor
) : NewsOutputs {

    override val newsList: Flow<List<News>> = newsInteractor
        .state
        .filterIsInstance<NewsInteractor.NewsState.Success>()
        .map { it.news }

    override val errorMessage: Flow<String> = newsInteractor
        .state
        .filterIsInstance<NewsInteractor.NewsState.Error>()
        .map { "Retrieving news failed" }

}

interface NewsOutputs {
    val newsList: Flow<List<News>>
    val errorMessage: Flow<String>
}