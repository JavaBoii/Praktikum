package zettel_3;

public class Book {
    private static long idCounter = 0;
    private final long id;
    private String title;
    private String authors;
    private long isbn;
    private boolean isBorrowed;

    public Book() {
        id = idCounter++;
    }

    public Book(String title, String authors, long isbn, boolean isBorrowed) {
        this();
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
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", isbn=" + isbn +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}

