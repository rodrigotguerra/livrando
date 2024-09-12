package com.rodrigotguerra.livrando.feature.journal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigotguerra.livrando.core.common.utils.toLiveData
import com.rodrigotguerra.livrando.core.data.repository.OfflineBookRepository
import com.rodrigotguerra.livrando.core.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class JournalViewModel @Inject constructor(
    private val offlineBookRepository: OfflineBookRepository,
    private val dispatcher: CoroutineDispatcher
) :
    ViewModel() {

    private val _booksList = MutableLiveData<List<Book>>()
    val booksList = _booksList.toLiveData()

    private val _selectedBook = MutableLiveData<Book>()
    val selectedBook = _selectedBook.toLiveData()

    private fun addBook(book: Book) {
        viewModelScope.launch() {
            val response = withContext(dispatcher) {
                offlineBookRepository.insertBook(book)
            }
            if (response.isSuccess) {
                getBooks()
            }
        }
    }

    fun removeBook(book: Book) {
        viewModelScope.launch {
            val response = withContext(dispatcher) {
                offlineBookRepository.deleteBook(book)
            }
            if (response.isSuccess) {
                getBooks()
            }
        }
    }

    fun getBookFromId(bookId: Int) {
        if (bookId < 0) {
            return
        }
        viewModelScope.launch {
            val book = withContext(dispatcher) {
                offlineBookRepository.getBookFromId(bookId)
            }
            _selectedBook.postValue(book)
        }
    }

    fun addOrUpdateBook(title: String, author: String, coverUrl: String, pages: Int, bookId: Int) {
        if (bookId < 0) {
            val book = Book(0, title, author, coverUrl, pages)
            addBook(book)
        } else {
            val book = Book(bookId, title, author, coverUrl, pages)
            updateBook(book)
        }
    }

    private fun updateBook(book: Book) {
        viewModelScope.launch {
            val response = withContext(dispatcher) {
                offlineBookRepository.updateBook(book)
            }
            if (response.isSuccess) {
                getBooks()
            }
        }
    }


    fun getBooks() {
        viewModelScope.launch {
            val books = withContext(dispatcher) {
                offlineBookRepository.getBooks()
            }
            _booksList.postValue(books)
        }
    }
}