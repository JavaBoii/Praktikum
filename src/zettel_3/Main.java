package zettel_3;

public class Main {

    public static void separator(int length) {
        System.out.print("\n#");
        for (int i = 0; i < length - 2; i++) {
            System.out.print("----");
        }
        System.out.println("#\n");
    }

    public static void main(String[] args) {
        // Erstellen von Büchern
        Book book1 = new Book("Buch1", "Autor1, Autor2", 1234567890L, false);
        Book book2 = new Book("Buch2", "Autor3", 2345678901L, false);
        Book book3 = new Book("Buch3", "Autor4, Autor5", 3456789012L, false);

        separator(33);

        // Testen der Book-Klasse
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        separator(33);

        book1.setTitle("Neuer Buch1 Titel");
        book1.setAuthors("Autor1, Autor 2, Autor6");
        book1.setIsbn(9876543210L);
        book1.setBorrowed(true);

        System.out.println(book1 + " (aktualisiert)");
        System.out.println(book2);
        System.out.println(book3);

        separator(33);

        // Erstellen von Studierenden
        Student student1 = new Student("Max Mustermann");
        System.out.println("Student1: " + student1.getName());

        separator(33);

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
        System.out.println("Verfügbare Bücher in der Bibliothek:");
        library.displayAvailableBooks();

        separator(33);

        // Zeige alle ausgeliehenen Bücher des Studierenden
        System.out.println("Ausgeliehene Bücher von " + student1.getName() + ":");
        student1.displayBorrowedBooks();

        separator(33);

        // Rückgabe eines Buches
        library.returnBook(student1, book1);

        // Zeige alle verfügbaren Bücher in der Bibliothek
        System.out.println("Verfügbare Bücher in der Bibliothek (nach Rückgabe):");
        library.displayAvailableBooks();

        separator(33);

        // Testen der isBookAvailable-Funktion
        System.out.println("Ist 'Buch1' verfügbar? " + (library.isBookAvailable("Buch1") ? "\u001B[32mtrue\u001B[0m" : "\u001B[31mfalse\u001B[0m"));
        System.out.println("Ist 'Buch4' verfügbar? " + (library.isBookAvailable("Buch4") ? "\u001B[32mtrue\u001B[0m" : "\u001B[31mfalse\u001B[0m"));


        separator(33);

        // Testen der isBorrowed-Funktion
        System.out.println("Ist 'Buch1' von Student1 ausgeliehen? " + (student1.isBorrowed("Buch1") ? "\u001B[31mtrue\u001B[0m" : "\u001B[32mfalse\u001B[0m"));
        System.out.println("Ist 'Buch2' von Student1 ausgeliehen? " + (student1.isBorrowed(book2) ? "\u001B[31mtrue\u001B[0m" : "\u001B[32mfalse\u001B[0m"));

    }
}
