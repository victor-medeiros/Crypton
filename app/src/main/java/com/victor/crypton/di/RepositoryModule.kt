package com.victor.crypton.di

import com.victor.crypton.data.repository.CryptoCoinRepositoryImpl
import com.victor.crypton.domain.repository.CryptoCoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun provideCryptoCoinRepository(cryptoCoinRepository: CryptoCoinRepositoryImpl): CryptoCoinRepository
}