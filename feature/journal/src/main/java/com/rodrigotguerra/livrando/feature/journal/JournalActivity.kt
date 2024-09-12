package com.rodrigotguerra.livrando.feature.journal

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rodrigotguerra.livrando.core.model.Book
import com.rodrigotguerra.livrando.feature.journal.adapter.BookAdapter
import com.rodrigotguerra.livrando.feature.journal.databinding.ActivityJournalBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class JournalActivity : AppCompatActivity(), BookClickListener  {

    private val viewModel: JournalViewModel by viewModels()
    private lateinit var binding: ActivityJournalBinding

    @Inject
    lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal)
        viewModel.getBooks()
        bindObservers()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.bookList.adapter = adapter
        adapter.clickListener = this
    }

    override fun onResume() {
        super.onResume()
        viewModel.getBooks()
    }

    private fun bindObservers() {
        viewModel.booksList.observe(this) {
            adapter.setBooks(it)
        }
    }

    override fun onBookClicked(bookId: Int) {
        val intent = Intent(this, BookDetailsActivity::class.java)
        intent.putExtra(BookDetailsActivity.BOOK_ID_EXTRA, bookId)
        startActivity(intent)
    }

}