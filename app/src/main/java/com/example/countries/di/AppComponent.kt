package com.example.countries.di

import androidx.lifecycle.ViewModel
import dagger.Component


@AppScope
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class,
        DomainModule::class,
        ApplicationModule::class
    ]
)
interface AppComponent {
    val mapModels: Map<Class<*>, ViewModel>
}