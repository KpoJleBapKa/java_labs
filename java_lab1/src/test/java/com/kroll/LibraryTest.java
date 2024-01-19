package com.kroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {
    private Library library;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        library = new Library();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Книга 1", "Автор 1", "ISBN1", 2023);
        library.addBook(book);
        assertTrue(library.getItems().contains(book));
    }

    @Test
    public void testRemoveBookByIsbn() {
        Book book1 = new Book("Книга 1", "Автор 1", "ISBN1", 2023);
        Book book2 = new Book("Книга 2", "Автор 2", "ISBN2", 2019);
        library.addBook(book1);
        library.addBook(book2);
        library.removeItemByIsbn("ISBN1");
        assertFalse(library.getItems().contains(book1));
        assertTrue(library.getItems().contains(book2));
    }

    @Test
    public void testFindBookByTitle() {
        Book book = new Book("Книга 1", "Автор 1", "ISBN1", 2023);
        library.addBook(book);
        Book foundBook = library.findBookByTitle("Книга 1");
        assertEquals(book, foundBook);
    }

    @Test
    public void testDisplayBooksWhenEmpty() {
        library.displayBooks();
        assertEquals("Бібліотека порожня.", outputStream.toString().trim());
    }

    @Test
    public void testDisplayBooks() {
        Book book1 = new Book("Книга 1", "Автор 1", "ISBN1", 2023);
        Book book2 = new Book("Книга 2", "Автор 2", "ISBN2", 2019);
        List<Item> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        library.setItems(books);

        library.displayBooks();

        String expectedOutput = "Книги в бібліотеці:" +
                "Книга: Книга 1 (Автор: Автор 1, Рік видання: 2023, ISBN: ISBN1)" +
                "Книга: Книга 2 (Автор: Автор 2, Рік видання: 2019, ISBN: ISBN2)";

        assertEquals(expectedOutput.replaceAll("\\s", ""), outputStream.toString().replaceAll("\\s", ""));
    }

    @Test
    public void testFindBookByTitleWhenBookExists() {
        Book book1 = new Book("Книга 1", "Автор 1", "ISBN1", 2023);
        Book book2 = new Book("Книга 2", "Автор 2", "ISBN2", 2019);
        List<Item> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        library.setItems(books);

        Book foundBook = library.findBookByTitle("Книга 1");

        assertEquals(book1, foundBook);
    }

    @Test
    public void testFindBookByTitleWhenBookDoesNotExist() {
        Book book1 = new Book("Книга 1", "Автор 1", "ISBN1", 2023);
        Book book2 = new Book("Книга 2", "Автор 2", "ISBN2", 2019);
        List<Item> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        library.setItems(books);

        Book foundBook = library.findBookByTitle("Книга 3");

        assertNull(foundBook);
    }
}
