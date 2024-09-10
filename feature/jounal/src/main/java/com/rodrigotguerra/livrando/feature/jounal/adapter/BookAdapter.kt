package com.rodrigotguerra.livrando.feature.jounal.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.rodrigotguerra.livrando.core.model.Book
import com.rodrigotguerra.livrando.feature.jounal.R
import com.rodrigotguerra.livrando.feature.jounal.databinding.BookViewBinding
import com.rodrigotguerra.livrando.core.ui.utils.ViewHolder
import com.rodrigotguerra.livrando.feature.jounal.databinding.AddBookViewBinding
import javax.inject.Inject

class BookAdapter @Inject constructor() :
    RecyclerView.Adapter<BookAdapter.BookContainerViewHolder>() {

    private val books = mutableListOf<Book>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookContainerViewHolder {
        return if (viewType == TYPE_ADD_VIEW) AddBookViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.book_view,
                parent,
                false
            )
        ) else BookViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.book_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookContainerViewHolder, position: Int) {
        if (position == itemCount - 1) {
            itemCount
        } else {
            itemCount
        }
    }

    override fun getItemCount(): Int = books.size + 1

    override fun getItemViewType(position: Int): Int =
        if (position == itemCount - 1) TYPE_ADD_VIEW else TYPE_BOOK_VIEW


    abstract inner class BookContainerViewHolder(binding: ViewDataBinding) :
        ViewHolder<View>(binding.root)

    inner class BookViewHolder(val binding: BookViewBinding) : BookContainerViewHolder(binding) {

    }

    inner class AddBookViewHolder(val binding: AddBookViewBinding) :
        BookContainerViewHolder(binding) {

    }
}