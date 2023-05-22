package zettel_3;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Book> borrowedBooks;

    public Student(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setBorrowed(true);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setBorrowed(false);
    }

    public void displayBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book.toString(true));
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean isBorrowed(Book book) {
        return borrowedBooks.contains(book);
    }

    public boolean isBorrowed(String title) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

}



