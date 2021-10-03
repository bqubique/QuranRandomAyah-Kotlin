package com.bqubique.quranrandomayah.di

import com.bqubique.quranrandomayah.api.QuranApi
import com.bqubique.quranrandomayah.model.Ayah
import com.bqubique.quranrandomayah.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    @Singleton
    @Named("quranApi")
    fun provideQuranApi(): QuranApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuranApi::class.java)
    }
}