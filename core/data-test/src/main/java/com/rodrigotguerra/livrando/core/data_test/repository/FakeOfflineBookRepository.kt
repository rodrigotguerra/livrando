package com.rodrigotguerra.livrando.core.data_test.repository

import com.rodrigotguerra.livrando.core.data.repository.BookRepository
import com.rodrigotguerra.livrando.core.model.Book


class FakeOfflineBookRepository() : BookRepository {

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
        try {
            val selectedBook = bookItems.find { item -> item.id == book.id}
            val index = bookItems.indexOf(selectedBook)
            if (index < 0) {
               throw Exception("Erro ao encontrar o livro")
            }
            bookItems[index] = book
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun getBookFromId(bookId: Int): Book {
        return bookItems.find { item -> item.id == bookId} ?: bookItems.first()
    }

    override suspend fun getBooks(): List<Book> {
        return bookItems
    }

    override suspend fun findBooksByName(search: String): List<Book> {
        return bookItems.filter { book: Book -> book.title.contains(search) }
    }
}