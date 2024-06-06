package com.victor.crypton.data.remote.dto

data class CryptoLogosListDto(
    val data: Map<String, List<CryptoLogoDto>>
)

data class CryptoLogoDto(
    val logo: String
)

