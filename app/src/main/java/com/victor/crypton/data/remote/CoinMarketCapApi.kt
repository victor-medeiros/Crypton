package com.victor.crypton.data.remote

import com.victor.crypton.data.remote.dto.CryptoLogosListDto
import com.victor.crypton.data.remote.dto.CurrencyListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinMarketCapApi {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCryptoCurrencies(
        @Query("limit") limit: Int = 30,
        @Query("convert") convert: String = "USD"
    ): Response<CurrencyListDto>

    @GET("v2/cryptocurrency/info")
    suspend fun getCryptoLogos(
        @Query("symbol") symbol: String,
        @Query("aux") aux: String = "logo"
    ): Response<CryptoLogosListDto>
}