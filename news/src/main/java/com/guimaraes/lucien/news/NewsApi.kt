package com.guimaraes.lucien.news

import retrofit2.http.GET

interface NewsApi {

    @GET("news")
    suspend fun getNewsList(): List<News>
}
