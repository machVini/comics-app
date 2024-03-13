package com.example.comics.di

import com.example.comics.data.repository.ComicRepository
import com.example.comics.data.repository.ComicRepositoryImpl
import com.example.comics.data.source.remote.ComicDataSource
import com.example.comics.data.source.remote.ComicDataSourceImpl
import com.example.comics.data.source.remote.api.Api
import com.example.comics.domain.usecase.GetComicsUseCase
import com.example.comics.domain.usecase.GetComicsUseCaseImpl
import com.example.comics.presentation.viewmodel.ComicViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

val viewModelModule = module {
    viewModel { ComicViewModel(get()) }
}
val useCaseModule = module {
    single<GetComicsUseCase> { GetComicsUseCaseImpl(get()) }
}

val repositoryModule = module {
    single<ComicRepository> { ComicRepositoryImpl(get()) }
}

val datasourceModule = module {
    single<ComicDataSource> { ComicDataSourceImpl(get()) }
}

val networkModule = module {
    single { provideRetrofit() }
    single { provideComicApi(get()) }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideComicApi(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
}