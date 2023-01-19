package com.example.countries.domain

import com.example.countries.data.entity.CountriesInfoItem

interface Repository {
    suspend fun getCountriesInfo() : List<CountriesInfoItem>
}