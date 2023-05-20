package zettel_3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private List<Student> students;

    public Library() {
        this.availableBooks = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public int getBorrowedBooks() {
        int borrowedBooksCounter = 0;
        for (Book book : availableBooks) {
            if (book.isBorrowed()) {
                borrowedBooksCounter++;
            }
        }
        return borrowedBooksCounter;
    }

    public List<Book> getAvailableBooks() {
        return this.availableBooks;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void borrowBook(Student student, Book book) {
        student.addBook(book);
        book.setBorrowed(true);
    }

    public void removeBook(Book book) {
        availableBooks.remove(book);
    }

    //getBook(editId)
    public Book getBook(long id) {
        for (Book book : availableBooks) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }


    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void addUser(Student student) {
        students.add(student);
    }

    public void returnBook(Student student, Book book) {
        student.removeBook(book);
        book.setBorrowed(false);
        if (!availableBooks.contains(book)) {
            availableBooks.add(book);
        }
    }

    public void displayAvailableBooks() {
        for (Book book : availableBooks) {
            System.out.println(book.toString());
        }
    }

    public boolean isBookAvailable(Book book) {
        return book.isBorrowed();
    }

    public boolean isBookAvailable(String title) {
        for (Book book : availableBooks) {
            if (book.getTitle().equals(title)) {
                return book.isBorrowed();
            }
        }
        return false;
    }

    public boolean isBookAvailable(long id) {
        for (Book book : availableBooks) {
            if (book.getId() == id) {
                return book.isBorrowed();
            }
        }
        return false;
    }
}


