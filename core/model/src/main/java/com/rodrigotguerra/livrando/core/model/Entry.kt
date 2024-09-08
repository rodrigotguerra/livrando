package com.rodrigotguerra.livrando.core.model

import java.util.Date

data class Entry (
    val book: Book,
    val date: Date,
    val sectionTime: Int,
    val currentPage: Int
) {
    val progress: Double get() = (currentPage / book.pages.toDouble()) * 100
}