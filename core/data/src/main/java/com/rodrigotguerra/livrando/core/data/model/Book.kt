package com.rodrigotguerra.livrando.core.data.model

import com.rodrigotguerra.livrando.core.database.model.BookEntity
import com.rodrigotguerra.livrando.core.model.Book

fun Book.asEntity() = BookEntity(
    id = id,
    title = title,
    author = author,
    coverUrl = coverUrl,
    pages = pages
)