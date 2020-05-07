package com.guimaraes.lucien.news

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class News(
    val title: String,
    val content: String,
    val moreInformationUrl: String = ""
)
