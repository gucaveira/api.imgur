package com.example.imgur.remote

import com.example.imgur.model.DataImgur
import com.example.imgur.network.ImgurApi

class RetrofitDataSource(private val marvelApi: ImgurApi) {

    suspend fun fetchImage(search: String): Result<DataImgur> {
        return runCatching {
            marvelApi.fetchImage(search)
        }
    }
}