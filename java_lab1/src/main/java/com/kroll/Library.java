package com.kroll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Library {
    private final List<Item> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    public void addBook(Book book) {
        items.add(book);
        System.out.println("Книгу додано до бібліотеки.");
    }

    public void displayBooks() {
        if (items.isEmpty()) {
            System.out.println("Бібліотека порожня.");
        } else {
            System.out.println("Книги в бібліотеці:");
            for (Item item : items) {
                if (item instanceof Book) {
                    System.out.println(item);
                }
            }
        }
    }

    public Book findBookByTitle(String title) {
        for (Item item : items) {
            if (item instanceof Book && item.getTitle().equalsIgnoreCase(title)) {
                return (Book) item;
            }
        }
        return null;
    }

    public void removeItemByIsbn(String isbn) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getIdentifier().equals(isbn)) {
                iterator.remove();
                System.out.println("Предмет з ISBN " + isbn + " видалено.");
                return;
            }
        }
        System.out.println("Предмет з ISBN " + isbn + " не знайдено в бібліотеці.");
    }

    public Item findItemByIdentifier(String identifier) {
        for (Item item : items) {
            if (item.getIdentifier().equals(identifier)) {
                return item;
            }
        }
        return null;
    }
}
