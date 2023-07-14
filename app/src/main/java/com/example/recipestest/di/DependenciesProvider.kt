package com.example.recipestest.di

import android.content.Context
import com.example.recipestest.common.error.ErrorProcessor
import com.example.recipestest.common.error.IErrorProcessor
import com.example.recipestest.common.error.INetworkErrorInterpreter
import com.example.recipestest.common.error.NetworkErrorInterpreter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependenciesProvider {

    @Provides
    @Singleton
    fun providesNetworkErrorInterpreter(
        @ApplicationContext context: Context
    ): INetworkErrorInterpreter {
        return NetworkErrorInterpreter(context)
    }

    @Provides
    @Singleton
    fun providesErrorProcessor(
        @ApplicationContext context: Context,
        iNetworkErrorInterpreter: INetworkErrorInterpreter
    ): IErrorProcessor {
        return ErrorProcessor(context, iNetworkErrorInterpreter)
    }
}