package com.rodrigotguerra.livrando.feature.journal

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rodrigotguerra.livrando.feature.journal.databinding.ActivityAddBookBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddBookActivity : AppCompatActivity() {

    private val viewModel: JournalViewModel by viewModels()
    private lateinit var binding: ActivityAddBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_book)
        binding.run {
            submitBook.setOnClickListener {
                viewModel.addBook(inputTitle.text.toString(), inputAuthor.text.toString(),"", inputPages.text.toString().toInt())
                finish()
            }
        }
    }
}