package com.example.imgur

import android.app.Application
import com.example.imgur.di.networkModule
import com.example.imgur.di.repositoryModule
import com.example.imgur.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ImgurApp : Application() {

    override fun onCreate() {
        super.onCreate()
       startKoin {
            androidContext(this@ImgurApp)
            modules(
                listOf(
                    networkModule,
                    viewModelModule,
                    repositoryModule
                )
            )
        }
    }
}