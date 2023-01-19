package com.example.countries.di

import androidx.lifecycle.ViewModel
import com.example.countries.domain.CountriesInfoUseCase
import com.example.countries.presentation.screens.countries.CountriesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @IntoMap
    @ClassKey(CountriesViewModel::class)
    @Provides
    fun getCountriesViewModel(
        useCase: CountriesInfoUseCase
    ): ViewModel = CountriesViewModel(useCase)

}