package com.rodrigotguerra.livrando.feature.jounal

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rodrigotguerra.livrando.feature.jounal.databinding.ActivityJournalBinding

class JournalActivity : AppCompatActivity() {

    private val viewModel: JournalViewModel by viewModels()
    private lateinit var binding: ActivityJournalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_journal)
    }

}