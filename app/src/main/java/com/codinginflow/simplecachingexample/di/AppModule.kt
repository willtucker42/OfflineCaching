package com.codinginflow.simplecachingexample.di

import com.codinginflow.simplecachingexample.api.RestaurantApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RestaurantApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): RestaurantApi{
        return retrofit.create(RestaurantApi::class.java)
    }

}