package com.victor.crypton.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victor.crypton.domain.model.CryptoCoin
import com.victor.crypton.domain.repository.CryptoCoinRepository
import com.victor.crypton.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cryptoCoinRepository: CryptoCoinRepository
) : ViewModel() {

    val cryptoCoins = MutableStateFlow<Resource<List<CryptoCoin>>>(Resource.Loading())

    init {
        viewModelScope.launch {
            cryptoCoins.emit(fetchCurrentCurrency())
        }
    }

    private suspend fun fetchCurrentCurrency(): Resource<List<CryptoCoin>> {
        val response = cryptoCoinRepository.getCurrentCurrency()
        if (response is Resource.Success) {
            val symbols = response.value.joinToString(separator = ",") { it.symbol }
            val logosResponse = cryptoCoinRepository.getCryptoLogos(symbols)
            if (logosResponse is Resource.Success) {
                response.value.forEach { cryptoCoin ->
                    cryptoCoin.logo = logosResponse.value[cryptoCoin.symbol] ?: ""
                }
            }
        }
        return response
    }
}