package com.rodrigotguerra.livrando.core.data.repository

import com.rodrigotguerra.livrando.core.model.Book

interface BookRepository {

    suspend fun insertBook(book: Book)

    suspend fun deleteBook(book: Book)

    suspend fun getBooks(): List<Book>

    suspend fun findBooksByName(search: String): List<Book>

}