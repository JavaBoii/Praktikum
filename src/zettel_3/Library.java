package zettel_3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private List<Student> students;
    private int changesBooks = 0;
    private int changesStudents = 0;
    private int changesBorrowedBooks = 0;
    private int lastBorrowedBookCount = 0;
    private int lastBookCount = 0;
    private int lastStudentCount = 0;

    public String getBookChangeSymbol() {
        if (changesBooks > lastBookCount) {
            return Styling.GREEN + "↑" + Styling.RESET;
        } else if (changesBooks < lastBookCount) {
            return Styling.RED + "↓" + Styling.RESET;
        } else {
            return Styling.YELLOW + "→" + Styling.RESET;
        }
    }

    public String getStudentChangeSymbol() {
        if (changesStudents > lastStudentCount) {
            return Styling.GREEN + "↑" + Styling.RESET;
        } else if (changesStudents < lastStudentCount) {
            return Styling.RED + "↓" + Styling.RESET;
        } else {
            return Styling.YELLOW + "→" + Styling.RESET;
        }
    }
    public String getBorrowedBookChangeSymbol() {
        if (changesBorrowedBooks > lastBorrowedBookCount) {
            return Styling.GREEN + "↑" + Styling.RESET;
        } else if (changesBorrowedBooks < lastBorrowedBookCount) {
            return Styling.RED + "↓" + Styling.RESET;
        } else {
            return Styling.YELLOW + "→" + Styling.RESET;
        }
    }
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
        student.borrowBook(book);
        book.setBorrowed(true);
        lastBorrowedBookCount = changesBorrowedBooks;
        changesBorrowedBooks = getBorrowedBooks();
    }

    public void removeBook(Book book) {
        availableBooks.remove(book);
        lastBookCount = changesBooks;
        changesBooks = availableBooks.size();
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
        lastBookCount = changesBooks;
        changesBooks = availableBooks.size();
    }

    public void addUser(Student student) {
        students.add(student);
        lastStudentCount = changesStudents;
        changesStudents = students.size();
    }

    public void removeUser(Student student) {
        students.remove(student);
        lastStudentCount = changesStudents;
        changesStudents = students.size();
    }

    public void returnBook(Student student, Book book) {
        student.returnBook(book);
        book.setBorrowed(false);
        lastBorrowedBookCount = changesBorrowedBooks;
        changesBorrowedBooks = getBorrowedBooks();
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


