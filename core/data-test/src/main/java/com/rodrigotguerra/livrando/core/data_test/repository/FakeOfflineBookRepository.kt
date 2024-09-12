package com.rodrigotguerra.livrando.core.data_test.repository

import com.rodrigotguerra.livrando.core.data.repository.BookRepository
import com.rodrigotguerra.livrando.core.model.Book


class FakeOfflineBookRepository : BookRepository {

    private val bookItems = mutableListOf<Book>()

    override suspend fun insertBook(book: Book): Result<Unit> {
        bookItems.add(book)
        return Result.success(Unit)
    }

    override suspend fun deleteBook(book: Book): Result<Unit>{
        bookItems.remove(book)
        return Result.success(Unit)
    }

    override suspend fun updateBook(book: Book): Result<Unit> {
        val selectedBook = bookItems.find { item -> item.id == book.id}
        return Result.success(Unit)
    }

    override suspend fun getBookFromId(bookId: Int): Book {
        TODO("Not yet implemented")
    }

    override suspend fun getBooks(): List<Book> {
        return bookItems
    }

    override suspend fun findBooksByName(search: String): List<Book> {
        return bookItems.filter { book: Book -> book.title.contains(search) }
    }
}