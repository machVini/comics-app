package com.example.comics

import android.app.Application
import com.example.comics.di.datasourceModule
import com.example.comics.di.networkModule
import com.example.comics.di.repositoryModule
import com.example.comics.di.useCaseModule
import com.example.comics.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(viewModelModule, useCaseModule, repositoryModule, datasourceModule, networkModule)
        }
    }
}