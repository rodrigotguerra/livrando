package com.rodrigotguerra.livrando.core.data_test.repository

import com.rodrigotguerra.livrando.core.data.repository.BookRepository
import com.rodrigotguerra.livrando.core.model.Book

class FakeOfflineBookRepository : BookRepository {

    private val bookItems = mutableListOf<Book>()

    override suspend fun insertBook(book: Book) {
        bookItems.add(book)
    }

    override suspend fun deleteBook(book: Book) {
        bookItems.remove(book)
    }

    override suspend fun getBooks(): List<Book> {
        return bookItems
    }

    override suspend fun findBooksByName(search: String): List<Book> {
        return bookItems.filter { book: Book -> book.title.contains(search) }
    }
}