package com.example.appmeteorologia.ui.theme.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmeteorologia.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {
    private val _weatherInfoState = MutableStateFlow(WeatherStateInfo())
    val weatherInfoState: StateFlow<WeatherStateInfo> = _weatherInfoState.asStateFlow()

    init {
        getWeatherInfo()
    }

    private fun getWeatherInfo() {
        viewModelScope.launch {
            val weatherInfo = weatherRepository.getWeatherData(
                (-6.585241999994415).toFloat(),
                (-36.77331945773032).toFloat()
            )
            _weatherInfoState.update {
                it.copy(weatherInfo = weatherInfo)
            }
        }
    }
}