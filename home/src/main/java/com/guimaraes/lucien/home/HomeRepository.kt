package com.guimaraes.lucien.home

import com.squareup.moshi.JsonClass
import retrofit2.http.GET

class HomeRepositoryImpl(
    private val gitHubApi: HomeApi
) : HomeRepository {

    override suspend fun requestRepo(): List<Repo> = gitHubApi.listRepos()
}

interface HomeRepository {
    suspend fun requestRepo(): List<Repo>
}


interface HomeApi {
    @GET("users/Guimareshh/repos")
    suspend fun listRepos(): List<Repo>

}

@JsonClass(generateAdapter = true)
data class Repo(
    val name: String
)
