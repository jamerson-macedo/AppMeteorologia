package com.example.appmeteorologia.data.repository

import com.example.appmeteorologia.data.model.WeatherInfo
import com.example.appmeteorologia.data.remote.RemoteDataSource
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale
import javax.inject.Inject
import kotlin.math.roundToInt

// injetando uma interface
class WeatherRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):WeatherRepository {
    override suspend fun getWeatherData(lat: Float, lng: Float): WeatherInfo {
        // aqui ja tenho os dados
       val response= remoteDataSource.getWeatherResponse(lat,lng)
        // transformar os dados da api e jogar para a view
        // pegando a primeira resposta
        val weather=response.weather[0]
        return WeatherInfo(
            locationName = response.name,
            conditionIcon = weather.icon,
            condition = weather.main,
            temperature = response.main.temp.roundToInt(),
            dayOfWeek = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()),
            // pego o ultimo caracter
            isDay = weather.icon.last()=='d'

        )
    }
}