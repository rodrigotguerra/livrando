package com.rodrigotguerra.livrando.core.data.repository

import com.rodrigotguerra.livrando.core.model.Book

interface BookRepository {

    suspend fun insertBook(book: Book): Result<Unit>

    suspend fun deleteBook(book: Book): Result<Unit>

    suspend fun updateBook(book: Book): Result<Unit>

    suspend fun getBookFromId(bookId: Int): Book

    suspend fun getBooks(): List<Book>

    suspend fun findBooksByName(search: String): List<Book>

}