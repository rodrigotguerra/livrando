package com.rodrigotguerra.livrando.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rodrigotguerra.livrando.core.database.model.BookEntity

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: BookEntity): Long

    @Delete
    suspend fun deleteBook(book: BookEntity): Int

    @Query("SELECT * FROM `livrando-database`")
    fun getBooks(): List<BookEntity>

    @Query("SELECT * FROM `livrando-database` WHERE title LIKE :search")
    fun findBooksByName(search: String): List<BookEntity>
}