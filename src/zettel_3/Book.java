package zettel_3;

import java.util.Date;
import java.text.SimpleDateFormat;
import styl.Styling;

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

        String borrowedColor = isBorrowed ? Styling.RED + "Nicht verfügbar" : Styling.GREEN + "   verfügbar   ";
        String lastBorrowedString = showLastBorrowed ? " | " + Styling.CYAN + "Last borrowed" + Styling.RESET + ": " + getLastBorrowedDateString() : "";

        return String.format("| " + Styling.CYAN + "ID" + Styling.RESET + ": %-4d | " + Styling.CYAN + "Title" + Styling.RESET + ": %-20s | " + Styling.CYAN + "Authors" + Styling.RESET + ": %-30s | " + Styling.CYAN + "ISBN" + Styling.RESET + ": %-13d | " + Styling.CYAN + "Status" + Styling.RESET + ": " + borrowedColor + Styling.RESET + lastBorrowedString + " |", id, truncatedTitle, authors, isbn);

    }

    public String toString() {
        return toString(false);
    }


}

