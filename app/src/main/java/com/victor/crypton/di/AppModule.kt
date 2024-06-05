package com.victor.crypton.di

import com.victor.crypton.BuildConfig
import com.victor.crypton.data.remote.AuthInterceptor
import com.victor.crypton.data.remote.CoinMarketCapApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(AuthInterceptor())
    }.build()

    @Singleton
    @Provides
    fun provideCoinMarketCapApi(client: OkHttpClient): CoinMarketCapApi = Retrofit.Builder()
        .baseUrl(BuildConfig.COIN_CURRENCY_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(CoinMarketCapApi::class.java)
}