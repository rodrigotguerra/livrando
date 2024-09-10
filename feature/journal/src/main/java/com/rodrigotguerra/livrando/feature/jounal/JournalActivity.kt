package com.rodrigotguerra.livrando.feature.jounal

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rodrigotguerra.livrando.feature.jounal.adapter.BookAdapter
import com.rodrigotguerra.livrando.feature.jounal.databinding.ActivityJournalBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class JournalActivity : AppCompatActivity() {

    private val viewModel: JournalViewModel by viewModels()
    private lateinit var binding: ActivityJournalBinding

    @Inject
    lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal)
        viewModel.getBooks()
        bindObservers()
    }

    private fun bindObservers() {
        viewModel.booksList.observe(this) {
            adapter.setBooks(it)
            binding.bookList.adapter = adapter
        }
    }

}