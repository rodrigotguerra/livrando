package com.rodrigotguerra.livrando.feature.jounal

import org.junit.Before
import com.rodrigotguerra.livrando.core.data_test.repository.FakeOfflineBookRepository
import kotlinx.coroutines.Dispatchers
import org.junit.Test

class JournalViewModelTest {

    private lateinit var viewModel: JournalViewModel

    @Before
    fun setup() {
        viewModel = JournalViewModel(FakeOfflineBookRepository(), Dispatchers.IO)
    }

    @Test
    fun `add a book success`() {
        viewModel.addBook("Testing View Model", "Author Name", "url", 40)

    }

}