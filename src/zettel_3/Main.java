package zettel_3;

public class Main {

    public static void separator(int length) {
        System.out.print("\n#");
        for (int i = 0; i < length - 2; i++) {
            System.out.print("----");
        }
        System.out.println("#\n");
    }

    static String Green = "\u001B[32m";
    static String Red = "\u001B[31m";
    static String Reset = "\u001B[0m";

    public static void main(String[] args) {
        // Erstellen von Büchern
        Book book1 = new Book();
        book1.setTitle("Buch1");
        book1.setAuthors("Autor1, Autor2");
        book1.setIsbn(1234567890L);
        book1.setBorrowed(false);

        Book book2 = new Book("Garry Lotter", "Grindewald", 2345678901L, false);
        Book book3 = new Book("Basic Chemistry", "Skyler White, Nestlé", 3456789012L, false);
        Book book4 = new Book("Buch4", "Autor6", 4567890123L, false);
        Book book5 = new Book("Buch5", "Autor7", 5678901234L, false);
        Book book6 = new Book("Intermediate Chemistry", "Skyler White, UnOwen", 6789012345L, false);
        Book book7 = new Book("Buch7", "Autor10, Autor11", 7890123456L, false);
        Book book8 = new Book("How to sell Drugs | Beginner Edition", "Autor12", 8901234567L, false);
        Book book9 = new Book("Advanced Chemistry", "Obamium, Thanos", 9012345678L, false);
        Book book10 = new Book("Buch10", "Autor15", 1234567891L, false);

        separator(33);

        // Testen der Book-Klasse
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);
        System.out.println(book6);
        System.out.println(book7);
        System.out.println(book8);
        System.out.println(book9);
        System.out.println(book10);

        separator(33);

        book1.setTitle("Neuer Buch1 Titel");
        book1.setAuthors("Autor1, Autor 2, Autor6");
        book1.setIsbn(9876543210L);
        book1.setBorrowed(true);

        System.out.println(book1 + " (aktualisiert)");
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);
        System.out.println(book6);
        System.out.println(book7);
        System.out.println(book8);
        System.out.println(book9);
        System.out.println(book10);

        separator(33);

        System.out.println("Buch1 Details:");
        System.out.println("ID: " + book1.getId());
        System.out.println("Titel: " + book1.getTitle());
        System.out.println("Autoren: " + book1.getAuthors());
        System.out.println("ISBN: " + book1.getIsbn());
        System.out.println("Ausgeliehen: " + book1.isBorrowed());

        separator(33);

        // Erstellen von Studierenden
        Student student1 = new Student("Max Mustermann");
        Student student2 = new Student("Walter White");
        System.out.println("Student1: " + student1.getName());
        System.out.println("Student2: " + student2.getName());

        separator(33);

        // Erstellen einer Bibliothek
        Library library = new Library();

        // Füge Bücher zur Bibliothek hinzu
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);

        // Füge den Studierenden zur Bibliothek hinzu
        library.addUser(student1);
        library.addUser(student2);

        // Ausleihen von Büchern durch Student1
        student1.addBook(book1);
        student1.addBook(book2);
        student1.addBook(book4);
        student1.addBook(book5);

        // Ausleihen von Büchern durch Student2
        student2.addBook(book3);
        student2.addBook(book6);
        student2.addBook(book8);
        student2.addBook(book9);

        // Zeige alle verfügbaren Bücher in der Bibliothek
        System.out.println("Verfügbare Bücher in der Bibliothek:");
        library.displayAvailableBooks();

        separator(33);

        // Zeige alle ausgeliehenen Bücher des Studierenden
        System.out.println("Ausgeliehene Bücher von " + student1.getName() + ":");
        student1.displayBorrowedBooks();

        separator(33);

        // Zeige alle ausgeliehenen Bücher des Studierenden
        System.out.println("Ausgeliehene Bücher von " + student2.getName() + ":");
        student2.displayBorrowedBooks();

        separator(33);

        // Rückgabe von Büchern durch Student1
        library.returnBook(student1, book1);
        library.returnBook(student1, book4);

        // Rückgabe von Büchern durch Student2
        library.returnBook(student2, book3);
        library.returnBook(student2, book9);

        // Zeige alle verfügbaren Bücher in der Bibliothek
        System.out.println("Verfügbare Bücher in der Bibliothek (nach Rückgabe):");
        library.displayAvailableBooks();

        separator(33);

        // Testen der isBookAvailable-Funktion
        System.out.println("Ist 'Buch1' verfügbar? " + (library.isBookAvailable("Buch1") ? Green + "Ja" + Reset : Red + "Nein" + Reset));
        System.out.println("Ist 'Buch4' verfügbar? " + (library.isBookAvailable("Buch4") ? Green + "Ja" + Reset : Red + "Nein" + Reset));
        System.out.println("Ist 'Buch6' verfügbar? " + (library.isBookAvailable(book6) ? Green + "Ja" + Reset : Red + "Nein" + Reset));


        separator(33);

        // Testen der isBorrowed-Funktion
        System.out.println("Ist 'Buch1' von Student1 ausgeliehen? " + (student1.isBorrowed("Buch1") ? Red + "Ausgeliehen" + Reset : Green + "Nicht Ausgeliehen" + Reset));
        System.out.println("Ist 'Buch2' von Student1 ausgeliehen? " + (student1.isBorrowed(book2) ? Red + "Ausgeliehen" + Reset : Green + "Nicht Ausgeliehen" + Reset));
        System.out.println("Ist 'Buch4' von Student2 ausgeliehen? " + (student2.isBorrowed(book4) ? Red + "Ausgeliehen" + Reset : Green + "Nicht Ausgeliehen" + Reset));
        System.out.println("Ist 'Buch7' von Student2 ausgeliehen? " + (student2.isBorrowed(book7) ? Red + "Ausgeliehen" + Reset : Green + "Nicht Ausgeliehen" + Reset));

    }
}
