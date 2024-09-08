package com.rodrigotguerra.livrando.core.database.di

import com.rodrigotguerra.livrando.core.database.LivrandoDatabase
import com.rodrigotguerra.livrando.core.database.dao.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {

    @Provides
    fun providesBookDao(database: LivrandoDatabase): BookDao = database.bookDao()

}