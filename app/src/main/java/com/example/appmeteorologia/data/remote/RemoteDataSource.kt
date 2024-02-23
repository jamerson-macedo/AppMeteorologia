package com.example.appmeteorologia.data.remote

import com.example.appmeteorologia.data.remote.response.WeatherDataResponse

interface RemoteDataSource {
    suspend fun getWeatherResponse(lat:Float,lng:Float):WeatherDataResponse
}