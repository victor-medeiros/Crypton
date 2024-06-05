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
        return response
    }
}