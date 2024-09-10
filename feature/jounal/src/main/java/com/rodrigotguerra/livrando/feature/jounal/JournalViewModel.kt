package com.rodrigotguerra.livrando.feature.jounal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigotguerra.livrando.core.data.repository.BookRepository
import com.rodrigotguerra.livrando.core.model.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class JournalViewModel @Inject constructor(private val offlineBookRepository: BookRepository) :
    ViewModel() {

    private val dispatcher = Dispatchers.IO

    private val _booksList = MutableLiveData<List<Book>>()
    val booksList: LiveData<List<Book>> get() = _booksList

    fun addBook(book: Book) {
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