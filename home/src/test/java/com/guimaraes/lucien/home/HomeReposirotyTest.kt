package com.guimaraes.lucien.home

import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.*
import org.junit.jupiter.api.Test

class HomeRepositoryTest {

    private val homeApi : HomeApi = mock()
    private val homeRepository: HomeRepository

    init {

        homeRepository = HomeRepositoryImpl(homeApi)
    }

    @Test
    fun `Given a call to get the list of repositories it should a list of repositories`() = runBlocking {
        When calling homeApi.listRepos() `it returns` repoFixtures

        homeRepository.requestRepo()

        Verify on homeApi that homeApi.listRepos() was called
        assert(homeRepository.requestRepo() == listOf(Repo("MyRepo1"), Repo("MyRepo2")))
    }

    @Test
    fun `Given a call to get the list of repositories it should an empty list of repositories`() = runBlocking {
        When calling homeApi.listRepos() `it returns` repoEmptyFixtures

        homeRepository.requestRepo()

        Verify on homeApi that homeApi.listRepos() was called
        assert(homeRepository.requestRepo() == emptyList<Repo>())
    }
}