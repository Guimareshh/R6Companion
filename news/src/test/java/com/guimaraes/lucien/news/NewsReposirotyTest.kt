package com.guimaraes.lucien.news

import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.*
import org.junit.jupiter.api.Test

class NewsRepositoryTest {

    private val newsApi : NewsApi = mock()
    private val newsRepository: NewsRepository

    init {
        newsRepository = NewsRepositoryImpl(newsApi)
    }

    @Test
    fun `Given a call to get the list of repositories it should a list of repositories`() = runBlocking {
        When calling newsApi.getNewsList() `it returns` newsListFixtures

        newsRepository.requestNewsList().collect()

        Verify on newsApi that newsApi.getNewsList() was called
        newsRepository.requestNewsList().collect {
            assert(it == newsListFixtures)
        }
    }

    @Test
    fun `Given a call to get the list of repositories it should an empty list of repositories`() = runBlocking {
        When calling newsApi.getNewsList() `it returns` newsEmptyFixtures

        newsRepository.requestNewsList().collect()

        Verify on newsApi that newsApi.getNewsList() was called
        newsRepository.requestNewsList().collect {
            assert(it.isEmpty())
        }
    }
}