package com.example.countries.di

import com.example.countries.domain.CountriesInfoUseCase
import com.example.countries.domain.Repository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideUsdCourseRepositoryUseCase(
        repository: Repository
    ): CountriesInfoUseCase = CountriesInfoUseCase(repository)
}