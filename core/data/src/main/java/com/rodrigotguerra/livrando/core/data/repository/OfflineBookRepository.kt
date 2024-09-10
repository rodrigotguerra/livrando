package com.rodrigotguerra.livrando.core.data.repository

import com.rodrigotguerra.livrando.core.data.model.asEntity
import com.rodrigotguerra.livrando.core.database.dao.BookDao
import com.rodrigotguerra.livrando.core.database.model.BookEntity
import com.rodrigotguerra.livrando.core.database.model.asExternalModel
import com.rodrigotguerra.livrando.core.model.Book
import javax.inject.Inject

internal class OfflineBookRepository @Inject constructor(private val bookDao: BookDao) :
    BookRepository {
    override suspend fun insertBook(book: Book) {
        bookDao.insertBook(book.asEntity())
    }

    override suspend fun deleteBook(book: Book) {
        bookDao.deleteBook(book.asEntity())
    }

    override suspend fun getBooks(): List<Book> {
        val books = bookDao.getBooks().map(BookEntity::asExternalModel)
        return books
    }

    override suspend fun findBooksByName(search: String): List<Book> {
        val books = bookDao.findBooksByName(search).map(BookEntity::asExternalModel)
        return books
    }

}