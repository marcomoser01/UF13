package com.dslab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.dslab.Objects.Book;

public class BookTest {

    @Test
    public void instaceShouldHaveSameAvailableBookNumbers() {
        Book book1 = new Book();
        Book book2 = new Book();

        assertEquals("Instance have same available book", book1.availableBook(), book2.availableBook(), 0);
    }

    @Test
    public void bookShouldContainATitle() {
        Book book = new Book();
        assertNull("Book should have a title", book.getTitle());
    }

}
