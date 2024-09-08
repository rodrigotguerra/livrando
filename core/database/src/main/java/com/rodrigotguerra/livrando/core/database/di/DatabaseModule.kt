package com.rodrigotguerra.livrando.core.database.di

import android.content.Context
import androidx.room.Room
import com.rodrigotguerra.livrando.core.database.LivrandoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesLivrandoDatabase(@ApplicationContext context: Context): LivrandoDatabase =
        Room.databaseBuilder(context, LivrandoDatabase::class.java, "livrando-database").build()
}