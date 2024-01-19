package com.kroll;

class Book extends Item {
    private final String author;
    private final int year;
    private final String isbn;

    public Book(String title, String author, String isbn, int year) {
        super(title, isbn);
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public String toString() {
        return getType() + ": " + super.getTitle() + " (Автор: " + author + ", Рік видання: " + year + ", ISBN: " + isbn + ")";
    }
}
