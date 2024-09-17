package com.rodrigotguerra.livrando.core.data.di

import com.rodrigotguerra.livrando.core.data.repository.BookRepository
import com.rodrigotguerra.livrando.core.data.repository.OfflineBookRepository
import com.rodrigotguerra.livrando.core.database.dao.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    @ViewModelScoped
    fun provideOfflineBookRepository(
        bookDao: BookDao,
        dispatcher: CoroutineDispatcher
    ): BookRepository = OfflineBookRepository(bookDao, dispatcher)

}