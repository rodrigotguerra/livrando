package com.rodrigotguerra.livrando.core.data.di

import com.rodrigotguerra.livrando.core.data.repository.BookRepository
import com.rodrigotguerra.livrando.core.data.repository.OfflineBookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsOfflineBookRepository(offlineBookRepository: OfflineBookRepository): BookRepository

}