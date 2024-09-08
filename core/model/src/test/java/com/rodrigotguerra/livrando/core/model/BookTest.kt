package com.rodrigotguerra.livrando.core.model

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BookTest {

    private lateinit var mock: Book

    @Before
    fun setUp() {
        mock = Book("Book Title", "Author Name", "url")
    }

    @Test
    fun `constructor with arguments success`() {
        val target = mock
        assertNotNull(target)
        assertEquals(mock.title, target.title)
        assertEquals(mock.author, target.author)
        assertEquals(mock.coverUrl, target.coverUrl)
    }

}