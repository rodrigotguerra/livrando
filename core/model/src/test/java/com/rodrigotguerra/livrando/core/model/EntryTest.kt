package com.rodrigotguerra.livrando.core.model

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.Date

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class EntryTest {

    private lateinit var mockBook: Book
    private lateinit var mockEntry: Entry

    @Before
    fun setUp() {
        mockBook = Book("Book Title", "Author Name", "url", 20)
        mockEntry = Entry(mockBook, Date(1000L), 30, 5)
    }

    @Test
    fun `book constructor with arguments success`() {
        val target = mockBook
        assertNotNull(target)
        assertEquals(mockBook.title, target.title)
        assertEquals(mockBook.author, target.author)
        assertEquals(mockBook.coverUrl, target.coverUrl)
        assertEquals(mockBook.pages, target.pages)
    }

    @Test
    fun `entry constructor with arguments success`() {
        val target = mockEntry
        assertNotNull(target)
        assertEquals(mockEntry.book, target.book)
        assertEquals(mockEntry.date, target.date)
        assertEquals(mockEntry.sectionTime, target.sectionTime)
        assertEquals(mockEntry.currentPage, target.currentPage)
    }

    @Test
    fun `entry progress percentage success`() {
        val target = mockEntry
        assertNotNull(target)
        assertEquals(25.0, target.progress, 0.01)
    }

}