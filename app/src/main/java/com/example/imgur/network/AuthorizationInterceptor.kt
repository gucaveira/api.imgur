package com.example.imgur.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(
    private val clientId: String,
    private val clientSecret: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header("Authorization", " Client-ID $clientId")
            .build()
        return chain.proceed(request)
    }
}
