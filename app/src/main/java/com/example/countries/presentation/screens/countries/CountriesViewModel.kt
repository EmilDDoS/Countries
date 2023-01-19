package com.example.countries.presentation.screens.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.data.entity.CountriesInfoItem
import com.example.countries.domain.CountriesInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val countriesInfoUseCase: CountriesInfoUseCase
) : ViewModel() {

    private val _countriesInfo = MutableStateFlow<LoadState>(LoadState.Loading)
    val countriesInfo: StateFlow<LoadState>
        get() = _countriesInfo.asStateFlow()

    fun update(){
        viewModelScope.launch {
            try {
                val result = countriesInfoUseCase.execute()
                _countriesInfo.tryEmit(LoadState.Success(result))
            } catch (e: Exception) {
                _countriesInfo.tryEmit(LoadState.Error(e.toString()))
            }
        }
    }

    sealed class LoadState {
        data class Success(val data: List<CountriesInfoItem>) : LoadState()
        data class Error(val message: String) : LoadState()
        object Loading : LoadState()
    }

}