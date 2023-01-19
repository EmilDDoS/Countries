package com.example.countries.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountriesInfoItem(
    val capital: String,
    val currencies: List<Currency>,
    val independent: Boolean,
    val name: String,
    val region: String,
    val timezones: List<String>,
    val flags: Flags
) : Parcelable