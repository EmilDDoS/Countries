package com.example.countries.di

import com.example.countries.data.RepositoryImpl
import com.example.countries.data.network.CountriesApi
import com.example.countries.domain.Repository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://restcountries.com/v2/"

@Module
class DataModule {
    @Provides
    fun provideApiFactory(): CountriesApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountriesApi::class.java)

    @Provides
    fun provideUsdCourseRepository(
        api: CountriesApi
    ): Repository = RepositoryImpl(api)
}