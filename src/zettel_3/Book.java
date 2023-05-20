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

    static String Green = "\u001B[32m";
    static String Red = "\u001B[31m";
    static String Reset = "\u001B[0m";

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

        String borrowedColor = isBorrowed ? Red + "Nicht verfügbar" : Green + "   verfügbar   ";
        String lastBorrowedString = showLastBorrowed ? " | Last borrowed: " + getLastBorrowedDateString() : "";

        return String.format("| ID: %-4d | Title: %-20s | Authors: %-30s | ISBN: %-13d | Status: " + borrowedColor + Reset + lastBorrowedString + " |", id, truncatedTitle, authors, isbn);

    }

    public String toString() {
        return toString(false);
    }


}

