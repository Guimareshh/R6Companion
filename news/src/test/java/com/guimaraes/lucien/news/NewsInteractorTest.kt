package com.guimaraes.lucien.news

import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.amshove.kluent.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class NewsInteractorTest {

    private val newsRepository: NewsRepository = mock()
    private val dismissCallback: () -> Unit = mock()
    private val coroutineDispatcher = TestCoroutineDispatcher()

    @Nested
    inner class SuccessCase {

        private val newsInteractor: NewsInteractor

        init {

            When calling newsRepository.requestNewsList() `it returns` flowOf(newsListFixtures)

            newsInteractor = NewsInteractorImpl(
                newsRepository,
                dismissCallback,
                coroutineDispatcher
            )
        }

        @Test
        fun `Given a succeed call to get the results it should be map to a new State`() = runBlocking {

            Verify on newsRepository that newsRepository.requestNewsList() was called

            newsInteractor.state.collect {
                assert(it == NewsInteractor.NewsState.Success(newsListFixtures))
            }
        }

    }


    @Nested
    inner class FailCase {

        private val newsInteractor: NewsInteractor
        private val throwable = Throwable()

        init {


            When calling newsRepository.requestNewsList() `it returns` flow { error(throwable) }

            newsInteractor = NewsInteractorImpl(
                newsRepository,
                dismissCallback,
                coroutineDispatcher
            )
        }

        @Test
        fun `Given a failed call to get the results it should be map to a new State`() = runBlocking {

            newsInteractor.state.collect {
                assert(it == NewsInteractor.NewsState.Error(throwable))
            }
        }

    }
}