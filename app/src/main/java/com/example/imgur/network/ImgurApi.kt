package com.example.imgur.network

import com.example.imgur.model.DataImgur
import retrofit2.http.GET
import retrofit2.http.Query

interface ImgurApi {
    @GET("search/")
    suspend fun fetchImage(@Query("q") search: String): DataImgur
}