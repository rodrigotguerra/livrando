package com.rodrigotguerra.livrando.feature.journal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rodrigotguerra.livrando.core.data_test.repository.FakeOfflineBookRepository
import com.rodrigotguerra.livrando.core.data_test.repository.MainDispatcherRule
import com.rodrigotguerra.livrando.core.model.Book
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class JournalViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val offlineBookRepository = FakeOfflineBookRepository()

    private lateinit var viewModel: JournalViewModel

    @Before
    fun setup() {
        viewModel = JournalViewModel(offlineBookRepository, mainDispatcherRule.testDispatcher)
    }

    @Test
    fun `add a book success`() = runTest {
        val bookMock = Book(-1, "Testing View Model","Author Name", "url", 40 )

        viewModel.addOrUpdateBook(bookMock)
        advanceUntilIdle()

        assertEquals(1, viewModel.booksList.value?.size)
        assertEquals(bookMock.title, viewModel.booksList.value?.get(0)?.title)
    }

    @Test
    fun `remove a book success`() = runTest {
        val bookMock = Book(0, "Testing View Model","Author Name", "url", 40 )

        offlineBookRepository.insertBook(bookMock)
        viewModel.getBooks()
        advanceUntilIdle()

        assertEquals(1, viewModel.booksList.value?.size)

        viewModel.removeBook(bookMock)
        advanceUntilIdle()

        assertEquals(0, viewModel.booksList.value?.size)
    }

    @Test
    fun `get a book from ID success`() = runTest {
        val bookMock = Book(0, "Book One","Author Name", "url", 40 )
        val bookMock2 = Book(1, "Book Two","Author Name", "url", 88 )


        offlineBookRepository.insertBook(bookMock)
        offlineBookRepository.insertBook(bookMock2)
        viewModel.getBooks()
        viewModel.getBookFromId(bookMock2.id)
        advanceUntilIdle()


        assertEquals(2, viewModel.booksList.value?.size)
        assertEquals(bookMock2, viewModel.selectedBook.value)
    }

}