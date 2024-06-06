package com.victor.crypton.domain.repository

import com.victor.crypton.domain.model.CryptoCoin
import com.victor.crypton.domain.util.Resource

interface CryptoCoinRepository {

    suspend fun getCurrentCurrency(limit: Int = 30): Resource<List<CryptoCoin>>
    suspend fun getCryptoLogos(symbols: String): Resource<Map<String, String>>
}