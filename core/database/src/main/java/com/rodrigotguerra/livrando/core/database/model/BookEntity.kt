package com.rodrigotguerra.livrando.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rodrigotguerra.livrando.core.model.Book

@Entity(tableName = "livrando-database")
data class BookEntity (
    @PrimaryKey
    val id: String,
    val title: String,
    val author: String,
    val coverUrl: String,
    val pages: Int
)

fun BookEntity.asExternalModel() = Book(
    id = id,
    title = title,
    author = author,
    coverUrl = coverUrl,
    pages = pages
)