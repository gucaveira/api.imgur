package com.example.imgur.repository

import com.example.imgur.model.DataImgur
import com.example.imgur.network.remote.RetrofitDataSource

class Repository(private val retroFitDataSource: RetrofitDataSource) {

    suspend fun fetchImage(search: String): Result<DataImgur> {
        return retroFitDataSource.fetchImage(search)
    }
}