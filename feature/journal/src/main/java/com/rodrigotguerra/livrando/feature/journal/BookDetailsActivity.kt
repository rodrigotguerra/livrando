package com.rodrigotguerra.livrando.feature.journal

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rodrigotguerra.livrando.core.model.Book
import com.rodrigotguerra.livrando.feature.journal.databinding.ActivityBookDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookDetailsActivity : AppCompatActivity() {

    private val viewModel: JournalViewModel by viewModels()
    private lateinit var binding: ActivityBookDetailsBinding
    private var bookId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectExtras()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book_details)
        binding.run {
            submitBook.setOnClickListener {
                viewModel.addOrUpdateBook(
                    inputTitle.text.toString(),
                    inputAuthor.text.toString(),
                    "",
                    inputPages.text.toString().toInt(),
                    bookId
                )
                finish()
            }
        }
        viewModel.getBookFromId(bookId)
        bindObservers()
    }

    private fun bindObservers() {
        viewModel.selectedBook.observe(this) { book ->
            binding.isUpdate = true
            setBookInputsText(book)
            binding.deleteBook.setOnClickListener {
                viewModel.removeBook(book)
                finish()
            }
        }
    }

    private fun setBookInputsText(book: Book) = binding.run {
        inputTitle.setText(book.title)
        inputAuthor.setText(book.author)
        inputPages.setText(book.pages.toString())
    }


    private fun injectExtras() {
        bookId = intent.getIntExtra(BOOK_ID_EXTRA, -1)
    }

    companion object {
        const val BOOK_ID_EXTRA = "bookId"
    }
}