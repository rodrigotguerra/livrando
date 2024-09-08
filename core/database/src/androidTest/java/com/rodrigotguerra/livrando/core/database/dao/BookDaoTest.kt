package com.rodrigotguerra.livrando.core.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.rodrigotguerra.livrando.core.database.LivrandoDatabase
import com.rodrigotguerra.livrando.core.database.model.BookEntity
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class BookDaoTest {

    private lateinit var database: LivrandoDatabase
    private lateinit var dao: BookDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            LivrandoDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.bookDao()
    }

    @Test
    fun insert_book_success() = runTest {
        val book = BookEntity("1", "Book Title", "Author Name", "url", 20)
        dao.insertBook(book)

        val byTitle = dao.findBooksByName("Book Title")
        assertEquals(byTitle[0], book)
    }

    @Test
    fun search_book_failed_then_success() = runTest {
        val book = BookEntity("2", "Another Book", "Author Name", "url", 20)
        dao.insertBook(book)

        var byTitle = dao.findBooksByName("Book Title")
        assertEquals(0, byTitle.size)

        byTitle = dao.findBooksByName("Another Book")
        assertNotEquals(0, byTitle.size)
        assertEquals(byTitle[0], book)
    }

    @After
    fun teardown() {
        database.close()
    }
}