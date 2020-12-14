package org.diiage.poc.app.di

import android.app.Application
import android.content.Context
import dagger.Module

import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {
    @Provides
    @Singleton
    fun providesContext(appInstance: Application): Context = appInstance.applicationContext

    @Provides
    fun providesDispatcher(): CoroutineDispatcher = Dispatchers.IO

}