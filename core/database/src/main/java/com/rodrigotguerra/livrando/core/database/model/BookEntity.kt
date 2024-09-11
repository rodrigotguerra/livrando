package com.rodrigotguerra.livrando.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rodrigotguerra.livrando.core.model.Book

@Entity(tableName = "livrando-database")
data class BookEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val author: String,
    @ColumnInfo(name = "cover_url")
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