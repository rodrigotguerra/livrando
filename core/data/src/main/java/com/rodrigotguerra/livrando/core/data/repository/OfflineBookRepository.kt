package com.rodrigotguerra.livrando.core.data.repository

import android.util.Log
import com.rodrigotguerra.livrando.core.common.utils.Constants
import com.rodrigotguerra.livrando.core.data.model.asEntity
import com.rodrigotguerra.livrando.core.database.dao.BookDao
import com.rodrigotguerra.livrando.core.database.model.BookEntity
import com.rodrigotguerra.livrando.core.database.model.asExternalModel
import com.rodrigotguerra.livrando.core.model.Book
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfflineBookRepository @Inject constructor(
    private val bookDao: BookDao,
    private val dispatcher: CoroutineDispatcher
) : BookRepository {

    override suspend fun insertBook(book: Book): Result<Unit> {
        try {
            val response = withContext(dispatcher) {
                bookDao.insertBook(book.asEntity())
            }
            if (response < 0) {
                throw Exception("Erro")
            }
            return Result.success(Unit)
        } catch (e: Exception) {
            Log.e(Constants.LOG, e.message.orEmpty())
            return Result.failure(e)
        }
    }

    override suspend fun deleteBook(book: Book): Result<Unit> {
        try {
            val response = withContext(dispatcher) {
                bookDao.deleteBook(book.asEntity())
            }
            if (response < 0) {
                throw Exception("Erro")
            }
            return Result.success(Unit)
        } catch (e: Exception) {
            Log.e(Constants.LOG, e.message.orEmpty())
            return Result.failure(e)
        }
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