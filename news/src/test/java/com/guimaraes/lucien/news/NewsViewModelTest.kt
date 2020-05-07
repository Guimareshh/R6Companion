package com.guimaraes.lucien.news

import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.When
import org.amshove.kluent.`it returns`
import org.amshove.kluent.calling
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NewsViewModelTest {

    private val newsInteractor: NewsInteractor = mock()


    @Nested
    inner class SuccessCase {

        private val newsViewModel: NewsViewModel

        init {
            When calling newsInteractor.state `it returns` flowOf(NewsInteractor.NewsState.Success(newsListFixtures))

            newsViewModel = NewsViewModel(newsInteractor)
        }

        @Test
        fun `Given a success state it should be mapped to a news list`() = runBlocking {
            newsViewModel.newsList.collect {
                assert(it == newsListFixtures)
            }
        }
    }


    @Nested
    inner class FailCase {

        private val newsViewModel: NewsViewModel

        init {

            When calling newsInteractor.state `it returns` flowOf(NewsInteractor.NewsState.Error(Throwable()))

            newsViewModel = NewsViewModel(newsInteractor)
        }


        @Test
        fun `Given a failed state it should be mapped to an error message`() = runBlocking {

            newsViewModel.errorMessage.collect {
                assert(it == "Retrieving news failed")
            }
        }
    }
}