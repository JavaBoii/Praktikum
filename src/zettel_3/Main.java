package zettel_3;

public class Main {
    public static void main(String[] args) {
        // Erstellen von Büchern
        Book book1 = new Book("Buch1", "Autor1, Autor2", 1234567890L, false);
        Book book2 = new Book("Buch2", "Autor3", 2345678901L, false);
        Book book3 = new Book("Buch3", "Autor4, Autor5", 3456789012L, false);

        // Erstellen von Studierenden
        Student student1 = new Student("Max Mustermann");

        // Erstellen einer Bibliothek
        Library library = new Library();

        // Füge Bücher zur Bibliothek hinzu
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Füge den Studierenden zur Bibliothek hinzu
        library.addUser(student1);

        // Ausleihen eines Buches
        student1.addBook(book1);

        // Zeige alle verfügbaren Bücher in der Bibliothek
        library.displayAvailableBooks();

        // Zeige alle ausgeliehenen Bücher des Studierenden
        student1.displayBorrowedBooks();

        // Rückgabe eines Buches
        library.returnBook(student1, book1);

        // Zeige alle verfügbaren Bücher in der Bibliothek
        library.displayAvailableBooks();
    }
}
