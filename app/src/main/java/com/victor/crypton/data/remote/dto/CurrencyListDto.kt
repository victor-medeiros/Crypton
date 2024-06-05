package com.victor.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.victor.crypton.domain.model.CryptoCoin
import java.math.BigDecimal

data class CurrencyListDto(
    val data: List<CryptoDto>
)

data class CryptoDto(
    val id: Long,
    val name: String,
    val symbol: String,
    val quote: Quote
) {
    fun toCryptoCoin() = CryptoCoin(
        id = id,
        name = name,
        symbol = symbol,
        currency = quote.usd.price
    )
}

data class Quote(
    @SerializedName("USD")
    val usd: UsdQuote
)

data class UsdQuote(
    val price: BigDecimal
)