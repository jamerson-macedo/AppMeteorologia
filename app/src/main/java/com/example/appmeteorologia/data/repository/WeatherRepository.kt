package com.example.appmeteorologia.data.repository

import com.example.appmeteorologia.data.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat:Float,lng:Float):WeatherInfo
}