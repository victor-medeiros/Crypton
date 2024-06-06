package com.victor.crypton.data.repository

import com.victor.crypton.data.remote.CoinMarketCapApi
import com.victor.crypton.domain.model.CryptoCoin
import com.victor.crypton.domain.repository.CryptoCoinRepository
import com.victor.crypton.domain.util.Resource
import java.lang.Exception
import javax.inject.Inject

const val UNEXPECTED_ERROR = "An unexpected error occurred."

class CryptoCoinRepositoryImpl @Inject constructor(
    private val coinMarketCapApi: CoinMarketCapApi
) : CryptoCoinRepository {
    override suspend fun getCurrentCurrency(limit: Int): Resource<List<CryptoCoin>> {
        return try {
            val response = coinMarketCapApi.getCryptoCurrencies()
            if (response.isSuccessful) {
                Resource.Success(value = response.body()!!.data.map { it.toCryptoCoin() })
            } else {
                Resource.Failure("$UNEXPECTED_ERROR ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Failure("$UNEXPECTED_ERROR ${e.message}")
        }
    }

    override suspend fun getCryptoLogos(symbols: String): Resource<Map<String, String>> {
        return try {
            val response = coinMarketCapApi.getCryptoLogos(symbols)
            if (response.isSuccessful) {
                Resource.Success(value = response.body()!!.data.mapValues { it.value[0].logo })
            } else {
                Resource.Failure("$UNEXPECTED_ERROR ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Failure("$UNEXPECTED_ERROR ${e.message}")
        }
    }
}