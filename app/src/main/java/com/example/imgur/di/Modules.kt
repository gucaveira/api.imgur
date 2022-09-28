package com.example.imgur.di

import com.example.imgur.BuildConfig
import com.example.imgur.BuildConfig.BASE_URL
import com.example.imgur.network.AuthorizationInterceptor
import com.example.imgur.network.ImgurApi
import com.example.imgur.network.remote.RetrofitDataSource
import com.example.imgur.repository.Repository
import com.example.imgur.viewModel.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    val authorizationInterceptor = AuthorizationInterceptor(
        clientId = BuildConfig.CLIENT_ID,
        clientSecret = BuildConfig.CLIENT_SECRET
    )

    single<ImgurApi> { get<Retrofit>().create(ImgurApi::class.java) }

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(authorizationInterceptor)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory { RetrofitDataSource(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    factory { Repository(get()) }
}