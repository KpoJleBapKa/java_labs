package com.kroll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Додати нову книгу в бібліотеку");
            System.out.println("2. Показати всі книги в бібліотеці");
            System.out.println("3. Знайти книгу за назвою");
            System.out.println("4. Видалити книгу за ISBN");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введіть назву книги:");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Введіть автора книги:");
                    String bookAuthor = scanner.nextLine();
                    System.out.println("Введіть номер ISBN книги:");
                    String bookIsbn = scanner.nextLine();
                    System.out.println("Введіть рік видання книги:");
                    int bookYear = scanner.nextInt();
                    scanner.nextLine();
                    Book book = new Book(bookTitle, bookAuthor, bookIsbn, bookYear);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.println("Введіть назву книги для пошуку:");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Знайдено книгу за назвою:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Книга за заданою назвою не знайдена.");
                    }
                    break;

                case 4:
                    System.out.println("Введіть ISBN книги для видалення:");
                    String isbnToRemove = scanner.nextLine();
                    library.removeItemByIsbn(isbnToRemove);
                    break;

                case 5:
                    System.out.println("Дякуємо за користування бібліотекою.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}