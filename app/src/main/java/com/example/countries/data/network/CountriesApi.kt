package com.example.countries.data.network

import com.example.countries.data.entity.CountriesInfoItem
import retrofit2.http.GET

interface CountriesApi {
    @GET("all?fields=name,currencies,regionalbloc,timezones,region,capital,currencies,flags")
    suspend fun getCountriesInfo(): List<CountriesInfoItem>
}