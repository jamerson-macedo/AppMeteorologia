package com.example.appmeteorologia.data.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

// singleton
// em qualquer lugar teremos acesso a essa instancia

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    // digo que so quero uma instancia

    @Provides
    @Singleton
    fun provideHTTPClient(): HttpClient {
        // pede a engine = Android
        return HttpClient(Android) {
            // pluguins no Ktor
            install(Logging) {
                logger = Logger.SIMPLE

            }
            install(ContentNegotiation) {
                json(Json {
                    // no logcaT imprime bonito o json
                    prettyPrint = true
                    // deixa o contrato menos burocratico
                    isLenient = true
                }

                )
            }
        }
    }
}