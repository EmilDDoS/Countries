package com.example.countries.di

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        componentApp = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var componentApp: AppComponent
    }
}