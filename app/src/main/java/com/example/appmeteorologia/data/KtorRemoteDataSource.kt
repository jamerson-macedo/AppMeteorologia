package com.example.appmeteorologia.data

import com.example.appmeteorologia.data.remote.RemoteDataSource
import com.example.appmeteorologia.data.remote.response.WeatherDataResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class KtorRemoteDataSource @Inject constructor(private val httpClient: HttpClient): RemoteDataSource {
    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/data/2.5"
    }

    override suspend fun getWeatherResponse(lat: Float, lng: Float): WeatherDataResponse {
        return httpClient.get("${BASE_URL}/weather?lat=$lat&lon=$lng&appid=130e62a28a27de46435e1a832a8f2d85&units=metric").body()
    }
}