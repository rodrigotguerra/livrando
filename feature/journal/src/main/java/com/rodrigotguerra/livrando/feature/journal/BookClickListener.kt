package com.rodrigotguerra.livrando.feature.journal

import com.rodrigotguerra.livrando.core.model.Book

interface BookClickListener {

    fun onBookClicked(book: Book)

}