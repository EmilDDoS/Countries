package com.example.countries.data

import com.example.countries.data.network.CountriesApi
import com.example.countries.domain.Repository

class RepositoryImpl(private val countriesApi: CountriesApi) : Repository {
    override suspend fun getCountriesInfo() = countriesApi.getCountriesInfo()
}