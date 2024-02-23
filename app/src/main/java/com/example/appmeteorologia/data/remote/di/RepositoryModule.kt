package com.example.appmeteorologia.data.remote.di

import com.example.appmeteorologia.data.repository.WeatherRepository
import com.example.appmeteorologia.data.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// apenas o viewmodel pode ver
@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    // nao faz o singleton
    // pq precisa de uma nova instancia
    // é isso que o viewmodel vai receber
    @Binds
    fun bindWeatherRepository(repositoryImpl: WeatherRepositoryImpl):WeatherRepository
}