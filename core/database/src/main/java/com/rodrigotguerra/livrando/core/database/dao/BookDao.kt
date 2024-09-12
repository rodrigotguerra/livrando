package com.rodrigotguerra.livrando.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rodrigotguerra.livrando.core.database.model.BookEntity

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBook(book: BookEntity): Long

    @Delete
    suspend fun deleteBook(book: BookEntity): Int

    @Update
    suspend fun update(book: BookEntity): Int

    @Query("SELECT * FROM `livrando-database` WHERE id = :bookId")
    suspend fun getBookFromId(bookId: Int): BookEntity

    @Query("SELECT * FROM `livrando-database`")
    fun getBooks(): List<BookEntity>

    @Query("SELECT * FROM `livrando-database` WHERE title LIKE :search")
    fun findBooksByName(search: String): List<BookEntity>
}