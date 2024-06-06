package com.victor.crypton.domain.model

import java.math.BigDecimal

data class CryptoCoin(
    val id: Long,
    val name: String,
    val symbol: String,
    var logo: String = "",
    val currency: BigDecimal
)
