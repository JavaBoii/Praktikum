package zettel_3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
    private String name;
    private List<Book> borrowedBooks;
    private Date lastBorrowedDate;

    public Student(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        borrowedBooks.add(book);
        book.setBorrowed(true);
        lastBorrowedDate = new Date();
    }

    public void removeBook(Book book) {
        borrowedBooks.remove(book);
        book.setBorrowed(false);
    }

    public void displayBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
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

    public int getBorrowedBooksCount() {
        return borrowedBooks.size();
    }
}


