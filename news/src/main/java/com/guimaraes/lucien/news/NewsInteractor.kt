package com.guimaraes.lucien.news

import com.guimaraes.lucien.news.NewsInteractor.NewsState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class NewsInteractorImpl(
    newsRepository: NewsRepository,
    private val dismissCallback: () -> Unit,
    ioDispatcher: CoroutineDispatcher
) : NewsInteractor {

    @ExperimentalCoroutinesApi
    override val state: Flow<NewsState> = newsRepository
        .requestNewsList()
        .flowOn(ioDispatcher)
        .map { NewsState.Success(it) }
        .catch { NewsState.Error(it) }
}

interface NewsInteractor : NewsInputs {

    sealed class NewsState {
        data class Error(val error: Throwable) : NewsState()
        data class Success(val news: List<News>) : NewsState()
    }

    val state: Flow<NewsState>
}

interface NewsInputs