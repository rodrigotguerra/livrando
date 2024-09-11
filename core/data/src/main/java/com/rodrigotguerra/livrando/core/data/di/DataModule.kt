package com.rodrigotguerra.livrando.core.data.di

import com.rodrigotguerra.livrando.core.data.repository.BookRepository
import com.rodrigotguerra.livrando.core.data.repository.OfflineBookRepository
import com.rodrigotguerra.livrando.core.database.dao.BookDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    @ViewModelScoped
    fun provideOfflineBookRepository(
        bookDao: BookDao,
        dispatcher: CoroutineDispatcher
    ): OfflineBookRepository = OfflineBookRepository(bookDao, dispatcher)

}