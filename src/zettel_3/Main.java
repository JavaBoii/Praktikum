package zettel_3;

import java.util.Scanner;

public class Main {

    public static void separator(int length) {
        System.out.print("\n#");
        for (int i = 0; i < length - 2; i++) {
            System.out.print("----");
        }
        System.out.println("#\n");
    }

    public static void separator(int length, String text) {
        System.out.print(text + "\n#");
        for (int i = 0; i < length - 2; i++) {
            System.out.print("----");
        }
        System.out.println("#\u001B[0m\n");
    }

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
        book1.setBorrowed(false);

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
        System.out.println("Ist 'Buch1' verfügbar? " + (library.isBookAvailable("Buch1") ? "\u001B[32mJa\u001B[0m" : "\u001B[31mNein\u001B[0m"));
        System.out.println("Ist 'Buch4' verfügbar? " + (library.isBookAvailable("Buch4") ? "\u001B[32mJa\u001B[0m" : "\u001B[31mNein\u001B[0m"));
        System.out.println("Ist 'Buch6' verfügbar? " + (library.isBookAvailable(book6) ? "\u001B[32mJa\u001B[0m" : "\u001B[31mNein\u001B[0m"));

        separator(33);

        // Testen der isBorrowed-Funktion
        System.out.println("Ist 'Buch1' von Student1 ausgeliehen? " + (student1.isBorrowed("Buch1") ? "\u001B[31mAusgeliehen\u001B[0m" : "\u001B[32mNicht Ausgeliehen\u001B[0m"));
        System.out.println("Ist 'Buch2' von Student1 ausgeliehen? " + (student1.isBorrowed(book2) ? "\u001B[31mAusgeliehen\u001B[0m" : "\u001B[32mNicht Ausgeliehen\u001B[0m"));
        System.out.println("Ist 'Buch4' von Student2 ausgeliehen? " + (student2.isBorrowed(book4) ? "\u001B[31mAusgeliehen\u001B[0m" : "\u001B[32mNicht Ausgeliehen\u001B[0m"));
        System.out.println("Ist 'Buch7' von Student2 ausgeliehen? " + (student2.isBorrowed(book7) ? "\u001B[31mAusgeliehen\u001B[0m" : "\u001B[32mNicht Ausgeliehen\u001B[0m"));

        separator(33);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // User Input area
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Was möchten Sie tun?");
            System.out.println("1: Buchverwaltung");
            System.out.println("2: Studentenverwaltung");
            System.out.println("3: Ausleihen");
            System.out.println("4: Rückgabe");
            System.out.println("5: Bücherdatenbank anzeigen");
            System.out.println("6: Beenden");

            //Lese die Eingabe des Users
            separator(33);
            System.out.print("\u001B[33mEingabe: \u001B[0m");
            int input = scanner.nextInt();
            scanner.nextLine();
            separator(33);

            switch (input) {
                case 1:
                    System.out.println("1: Buch hinzufügen, 2: Buch löschen, 3: Buch bearbeiten, 4: Zurück");
                    separator(33);
                    System.out.print("\u001B[33mEingabe: \u001B[0m");
                    int bookInput = scanner.nextInt();
                    scanner.nextLine();
                    separator(33);

                    switch (bookInput) {
                        case 1:
                            boolean runningBook = true;
                            while (runningBook) {
                                System.out.println("Geben Sie den Titel des Buches ein:");
                                String newTitle = scanner.nextLine();
                                System.out.println("Geben Sie die Autoren des Buches ein:");
                                String newAuthors = scanner.nextLine();
                                System.out.println("Geben Sie die ISBN des Buches ein:");
                                long newIsbn = scanner.nextLong();
                                scanner.nextLine();
                                Book newBook = new Book(newTitle, newAuthors, newIsbn, false);
                                library.addBook(newBook);

                                separator(33, "\u001B[32m");
                                System.out.print("\u001B[32mBuch erfolgreich hinzugefügt\n\n\u001B[0m");
                                System.out.println(newBook);
                                separator(33, "\u001B[32m");

                                System.out.println("Möchten Sie ein weiteres Buch hinzufügen? (1: \u001B[32mJa\u001B[0m, 2: \u001B[31mNein\u001B[0m)");

                                separator(33);
                                System.out.print("\u001B[33mEingabe: \u001B[0m");
                                int bookInput2 = scanner.nextInt();
                                scanner.nextLine();
                                separator(33);

                                if (bookInput2 == 2) {
                                    runningBook = false;
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Geben Sie die ID des zu löschenden Buches ein:");
                            separator(33);
                            System.out.print("\u001B[33mEingabe: \u001B[0m");
                            long deleteId = scanner.nextLong();
                            scanner.nextLine();
                            separator(33);
                            for (Book book : library.getAvailableBooks()) {
                                if (book.getId() == deleteId) {
                                    library.removeBook(book);
                                    separator(33, "\u001B[32m");
                                    System.out.print("\u001B[32mBuch erfolgreich gelöscht\n\u001B[0m");
                                    separator(33, "\u001B[32m");
                                    break;
                                } else {
                                    separator(33, "\u001B[31m");
                                    System.out.print("\u001B[31mBuch nicht im System\n\u001B[0m");
                                    separator(33, "\u001B[31m");
                                    break;
                                }
                            }

                            break;
                        case 3:
                            System.out.println("Geben Sie die ID des zu bearbeitenden Buches ein:");
                            separator(33);
                            System.out.print("\u001B[33mEingabe: \u001B[0m");
                            long editId = scanner.nextLong();
                            scanner.nextLine();
                            String tmp = "";
                            separator(33, "\u001B[33m");
                            for (Book book : library.getAvailableBooks()) {
                                if (book.getId() == editId) {
                                    tmp = book.toString();
                                    System.out.println("\u001B[33mGeben Sie den neuen Titel des Buches ein:\u001B[0m");
                                    String editTitle = scanner.nextLine();
                                    System.out.println("\u001B[33mGeben Sie die neuen Autoren des Buches ein:\u001B[0m");
                                    String editAuthors = scanner.nextLine();
                                    System.out.println("\u001B[33mGeben Sie die neue ISBN des Buches ein:\u001B[0m");
                                    long editIsbn = scanner.nextLong();
                                    scanner.nextLine();
                                    //Wenn der user nichts eingibt, wird der alte Wert übernommen
                                    if (editTitle.equals("")) {
                                        editTitle = book.getTitle();
                                    }
                                    if (editAuthors.equals("")) {
                                        editAuthors = book.getAuthors();
                                    }
                                    if (editIsbn == 0) {
                                        editIsbn = book.getIsbn();
                                    }
                                    book.setTitle(editTitle);
                                    book.setAuthors(editAuthors);
                                    book.setIsbn(editIsbn);
                                    break;
                                }
                            }
                            separator(33, "\u001B[33m");

                            separator(33, "\u001B[32m");
                            System.out.print("\u001B[32mBuch erfolgreich bearbeitet\n\n\u001B[0m");
                            System.out.println("\u001B[33mVorher:  \u001B[0m" + tmp);
                            System.out.println("\u001B[32mNachher: \u001B[0m" + library.getBook(editId));
                            separator(33, "\u001B[32m");
                            break;
                        case 4:
                            break;
                        default:
                            separator(33);
                            System.out.println("Ungültige Eingabe, bitte erneut eingeben.");
                            separator(33);
                    }
                    break;
                case 2:
                    System.out.println("1: Student hinzufügen, 2: Student löschen, 3: Student anzeigen, 4: Zurück");
                    separator(33);
                    System.out.print("\u001B[33mEingabe: \u001B[0m");
                    int studentInput = scanner.nextInt();
                    scanner.nextLine();
                    separator(33);

                    switch (studentInput) {
                        case 1:
                            System.out.println("Geben Sie den Namen des Studenten ein:");
                            System.out.print("\u001B[33mEingabe: \u001B[0m");
                            String newStudentName = scanner.nextLine();
                            library.addUser(new Student(newStudentName));
                            separator(33);
                            break;
                        case 2:
                            System.out.println("Geben Sie den Namen des zu löschenden Studenten ein:");
                            System.out.print("\u001B[33mEingabe: \u001B[0m");
                            String deleteStudentName = scanner.nextLine();
                            for (Student student : library.getStudents()) {
                                if (student.getName().equals(deleteStudentName)) {
                                    library.getStudents().remove(student);
                                    break;
                                }
                            }
                            separator(33);
                            break;
                        case 3:
                            System.out.println("Geben Sie den Namen des anzuzeigenden Studenten ein:");
                            System.out.print("\u001B[33mEingabe: \u001B[0m");
                            String displayStudentName = scanner.nextLine();
                            for (Student student : library.getStudents()) {
                                if (student.getName().equals(displayStudentName)) {
                                    student.displayBorrowedBooks();
                                    break;
                                }
                            }
                            separator(33);
                            break;
                        case 4:
                            break;
                        default:
                            separator(33, "\u001B[31m");
                            System.out.println("\u001B[31mUngültige Eingabe\u001B[0m");
                            separator(33, "\u001B[31m");
                    }
                    break;
                case 3:
                    System.out.println("Geben Sie die ID des Buches ein, das Sie ausleihen möchten:");
                    System.out.print("\u001B[33mEingabe: \u001B[0m");
                    String bookId = scanner.nextLine();
                    long bookIdLong = Long.parseLong(bookId);

                    if (!library.isBookAvailable(bookIdLong)) {
                        // Find the book
                        Book targetBook = null;
                        for (Book book : library.getAvailableBooks()) {
                            if (book.getId() == Long.parseLong(bookId)) {
                                targetBook = book;
                                break;
                            }
                        }
                        if (targetBook != null) {
                            // Ask for confirmation
                            separator(33, "\u001B[36m");
                            System.out.println("\u001B[36mMöchten Sie '\u001B[0m" + targetBook + "\u001B[36m' ausleihen? \n\u001B[0m [\u001B[32my\u001B[0m / \u001B[31mn\u001B[0m]");
                            separator(33, "\u001B[36m");
                            System.out.print("\u001B[33mEingabe: \u001B[0m");
                            String confirmation = scanner.nextLine();

                            if (confirmation.toLowerCase().equals("y")) {
                                System.out.println("Für welchen Studenten?");
                                System.out.print("\u001B[33mEingabe: \u001B[0m");
                                String studentName = scanner.nextLine();
                                // Find the student
                                Student targetStudent = null;
                                for (Student student : library.getStudents()) {
                                    if (student.getName().equals(studentName)) {
                                        targetStudent = student;
                                        break;
                                    }
                                }
                                if (targetStudent != null) {

                                    // If both student and book are found, borrow the book
                                    library.borrowBook(targetStudent, targetBook);
                                    separator(33, "\u001B[32m");
                                    System.out.print("\u001B[32mBuch erfolgreich ausgeliehen von: \u001B[36m" + targetStudent.getName() + ".\n\u001B[0m");
                                    separator(33, "\u001B[32m");

                                }
                            }
                        } else {
                            System.out.println("\u001B[31mBuch nicht gefunden.\u001B[0m");
                        }

                    } else {
                        System.out.println("\u001B[31mBuch nicht verfügbar.\u001B[0m");
                    }
                    separator(33);
                    break;
                case 4:
                    //Buch rückgabe
                    System.out.println("Geben Sie den Namen des Studenten ein, der ein Buch zurückgeben möchte:");
                    System.out.print("\u001B[33mEingabe: \u001B[0m");
                    String studentName = scanner.nextLine();
                    // Find the student
                    Student targetStudent = null;
                    for (Student student : library.getStudents()) {
                        if (student.getName().equals(studentName)) {
                            targetStudent = student;
                            break;
                        }
                    }
                    if (targetStudent != null) {
                        System.out.println("Geben Sie die Id des Buches ein, das zurückgegeben werden soll aus dieser Liste:");
                        targetStudent.displayBorrowedBooks();
                        System.out.print("\u001B[33mEingabe: \u001B[0m");
                        String returnBook = scanner.nextLine();
                        // Find the book
                        Book targetBook = null;
                        for (Book book : targetStudent.getBorrowedBooks()) {
                            if (book.getId() == Integer.parseInt(returnBook)) {
                                targetBook = book;
                                break;
                            }
                        }
                        if (targetBook != null) {
                            // If both student and book are found, return the book
                            library.returnBook(targetStudent, targetBook);
                            separator(33, "\u001B[32m");
                            System.out.print("\u001B[32mBuch erfolgreich zurückgegeben von: \u001B[36m" + targetStudent.getName() + ".\n\u001B[0m");
                            separator(33, "\u001B[32m");
                        }
                    }

                    break;
                case 5:
                    library.displayAvailableBooks();
                    separator(33);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    separator(33, "\u001B[31m");
                    System.out.println("\u001B[31mUngültige Eingabe\u001B[0m");
                    separator(33, "\u001B[31m");
            }
        }

    }
}
