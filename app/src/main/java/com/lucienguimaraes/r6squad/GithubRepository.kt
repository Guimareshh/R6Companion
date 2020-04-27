package com.lucienguimaraes.r6squad

import com.squareup.moshi.JsonClass
import retrofit2.http.GET

class GithubRepositoryImpl(
    private val gitHubApi: GitHubApi
) : GithubRepository {

    override suspend fun requestRepo(): List<Repo> = gitHubApi.listRepos()
}

interface GithubRepository {
    suspend fun requestRepo(): List<Repo>
}


interface GitHubApi {
    @GET("users/Guimareshh/repos")
    suspend fun listRepos(): List<Repo>

}

@JsonClass(generateAdapter = true)
data class Repo(
    val name: String
)
