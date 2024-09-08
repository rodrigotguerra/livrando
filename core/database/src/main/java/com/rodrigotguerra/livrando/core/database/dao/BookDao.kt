package com.rodrigotguerra.livrando.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rodrigotguerra.livrando.core.database.model.BookEntity

@Dao
interface BookDao {

    @Insert
    suspend fun insertBook(book: BookEntity) : List<Long>

    @Query("SELECT * FROM `livrando-database`")
    fun getBooks(): List<BookEntity>
}