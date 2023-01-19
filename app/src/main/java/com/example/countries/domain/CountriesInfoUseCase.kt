package com.example.countries.domain

class CountriesInfoUseCase(private val repository: Repository) {
    suspend fun execute() = repository.getCountriesInfo()
}