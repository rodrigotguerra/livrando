package com.rodrigotguerra.livrando.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rodrigotguerra.livrando.core.database.dao.BookDao
import com.rodrigotguerra.livrando.core.database.model.BookEntity

@Database(entities = [BookEntity::class], version = 1)
internal abstract class LivrandoDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao
}