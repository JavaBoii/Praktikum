package zettel_3;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Book {
    private static long idCounter = 1;
    private final long id;
    private String title;
    private String authors;
    private long isbn;
    private boolean isBorrowed;
    private Date lastBorrowedDate;

    public Book() {
        id = idCounter++;
    }

    public Book(String title, String authors, long isbn, boolean isBorrowed) {
        this.id = idCounter++;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.isBorrowed = isBorrowed;
    }

// you suck

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
        if (borrowed) {
            lastBorrowedDate = new Date();
        }
    }

    public String getLastBorrowedDateString() {
        if (lastBorrowedDate == null) {
            return "N/A";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(lastBorrowedDate);
    }

    private String truncateTitle(String title, int maxLength) {
        if (title.length() > maxLength) {
            return title.substring(0, maxLength - 3) + "...";
        }
        return title;
    }

    public String toString(boolean showLastBorrowed) {
        String truncatedTitle = truncateTitle(title, 20);

        String borrowedColor = isBorrowed ? "\u001B[31mNicht verfügbar" : "\u001B[32m   verfügbar   ";
        String resetColor = "\u001B[0m";
        String lastBorrowedString = showLastBorrowed ? " | Last borrowed: " + getLastBorrowedDateString() : "";

        return String.format("| ID: %-4d | Title: %-20s | Authors: %-30s | ISBN: %-13d | Borrowed: " + borrowedColor + resetColor + lastBorrowedString + " |", id, truncatedTitle, authors, isbn);
    }

    public String toString() {
        return toString(false);
    }


}

