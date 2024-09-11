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

    fun addBook(title: String, author: String, coverUrl: String, pages: Int) {
        val book = Book(0, title, author, coverUrl, pages)
        viewModelScope.launch(dispatcher) {
            offlineBookRepository.insertBook(book)
        }
    }

    fun removeBook(book: Book) {
        viewModelScope.launch(dispatcher) {
            offlineBookRepository.deleteBook(book)
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