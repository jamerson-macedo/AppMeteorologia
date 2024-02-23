package com.example.appmeteorologia.data.di

import com.example.appmeteorologia.data.KtorRemoteDataSource
import com.example.appmeteorologia.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    // implementa uma abstração por exemplo as interfaces
    @Binds
    @Singleton
    fun bindRemoteDataSource(remoteDataSource: KtorRemoteDataSource):RemoteDataSource
}