package zettel_3;

import java.util.Scanner;

public class Main {

    public static void message(String color, String message, String body) {
        separator(Styling.SEPARATOR_SIZE, color);
        System.out.print(color + message + "\n" + Styling.RESET);
        System.out.print(body);
        separator(Styling.SEPARATOR_SIZE, color);
    }

    public static void message(String color, String message) {
        separator(Styling.SEPARATOR_SIZE, color);
        System.out.print(color + message + "\n" + Styling.RESET);
        separator(Styling.SEPARATOR_SIZE, color);
    }

    public static void userInputRequest(String input) {
        System.out.println(input);
        System.out.print(Styling.YELLOW + "Eingabe: " + Styling.RESET);
    }

    public static void userInputRequest(String input, String colorOut, String colorIn, boolean separator) {
        System.out.println(colorOut + input + Styling.RESET);
        separator(Styling.SEPARATOR_SIZE);
        System.out.print(colorIn + "Eingabe: " + Styling.RESET);
    }

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
        System.out.println("#" + Styling.RESET + "\n");
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

        separator(Styling.SEPARATOR_SIZE);

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

        separator(Styling.SEPARATOR_SIZE);

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

        separator(Styling.SEPARATOR_SIZE);

        System.out.println("Buch1 Details:");
        System.out.println("ID: " + book1.getId());
        System.out.println("Titel: " + book1.getTitle());
        System.out.println("Autoren: " + book1.getAuthors());
        System.out.println("ISBN: " + book1.getIsbn());
        System.out.println("Ausgeliehen: " + book1.isBorrowed());

        separator(Styling.SEPARATOR_SIZE);

        // Erstellen von Studierenden
        Student student1 = new Student("Max Mustermann");
        Student student2 = new Student("Walter White");
        System.out.println("Student1: " + student1.getName());
        System.out.println("Student2: " + student2.getName());

        separator(Styling.SEPARATOR_SIZE);

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
        student1.borrowBook(book1);
        student1.borrowBook(book2);
        student1.borrowBook(book4);
        student1.borrowBook(book5);

        // Ausleihen von Büchern durch Student2
        student2.borrowBook(book3);
        student2.borrowBook(book6);
        student2.borrowBook(book8);
        student2.borrowBook(book9);

        // Zeige alle verfügbaren Bücher in der Bibliothek
        System.out.println("Verfügbare Bücher in der Bibliothek:");
        library.displayAvailableBooks();

        separator(Styling.SEPARATOR_SIZE);

        // Zeige alle ausgeliehenen Bücher des Studierenden
        System.out.println("Ausgeliehene Bücher von " + student1.getName());
        student1.displayBorrowedBooks();

        separator(Styling.SEPARATOR_SIZE);

        // Zeige alle ausgeliehenen Bücher des Studierenden
        System.out.println("Ausgeliehene Bücher von " + student2.getName() + ":");
        student2.displayBorrowedBooks();

        separator(Styling.SEPARATOR_SIZE);

        // Rückgabe von Büchern durch Student1
        library.returnBook(student1, book1);
        library.returnBook(student1, book4);

        // Rückgabe von Büchern durch Student2
        library.returnBook(student2, book3);
        library.returnBook(student2, book9);

        // Zeige alle verfügbaren Bücher in der Bibliothek
        System.out.println("Verfügbare Bücher in der Bibliothek (nach Rückgabe):");
        library.displayAvailableBooks();

        separator(Styling.SEPARATOR_SIZE);

        // Testen der isBookAvailable-Funktion
        System.out.println("Ist 'Buch1' verfügbar? " + (library.isBookAvailable("Buch1") ? Styling.GREEN + "Ja" + Styling.RESET : Styling.RED + "Nein" + Styling.RESET));
        System.out.println("Ist 'Buch4' verfügbar? " + (library.isBookAvailable("Buch4") ? Styling.GREEN + "Ja" + Styling.RESET : Styling.RED + "Nein" + Styling.RESET));
        System.out.println("Ist 'Buch6' verfügbar? " + (library.isBookAvailable(book6) ? Styling.GREEN + "Ja" + Styling.RESET : Styling.RED + "Nein" + Styling.RESET));

        separator(Styling.SEPARATOR_SIZE);

        // Testen der isBorrowed-Funktion
        System.out.println("Ist 'Buch1' von Student1 ausgeliehen? " + (student1.isBorrowed("Buch1") ? Styling.RED + "Ausgeliehen" + Styling.RESET : Styling.GREEN + "Nicht Ausgeliehen" + Styling.RESET));
        System.out.println("Ist 'Buch2' von Student1 ausgeliehen? " + (student1.isBorrowed(book2) ? Styling.RED + "Ausgeliehen" + Styling.RESET : Styling.GREEN + "Nicht Ausgeliehen" + Styling.RESET));
        System.out.println("Ist 'Buch4' von Student2 ausgeliehen? " + (student2.isBorrowed(book4) ? Styling.RED + "Ausgeliehen" + Styling.RESET : Styling.GREEN + "Nicht Ausgeliehen" + Styling.RESET));
        System.out.println("Ist 'Buch7' von Student2 ausgeliehen? " + (student2.isBorrowed(book7) ? Styling.RED + "Ausgeliehen" + Styling.RESET : Styling.GREEN + "Nicht Ausgeliehen" + Styling.RESET));

        separator(Styling.SEPARATOR_SIZE);

        System.out.println("Es sind: " + Styling.GREEN + library.getBorrowedBooks() + Styling.RESET + " Bücher ausgeliehen.");

        separator(Styling.SEPARATOR_SIZE);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // User Input area
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Willkommen in der Bibliothek!");
        while (running) {
            System.out.print(Styling.BOLD + Styling.ULINE + "Status:" + Styling.RESET + "\nEs sind " + Styling.GREEN + library.getBorrowedBooks() + Styling.RESET + " Bücher ausgeliehen.");
            System.out.println(library.getBorrowedBookChangeSymbol());
            System.out.print("Es sind " + Styling.GREEN + library.getAvailableBooks().size() + Styling.RESET + " Bücher registriert.");
            System.out.println(library.getBookChangeSymbol());
            System.out.print("Es sind " + Styling.GREEN + library.getStudents().size() + Styling.RESET + " Studenten im System.");
            System.out.println(library.getStudentChangeSymbol());

            System.out.println("\nWas möchten Sie tun?");
            System.out.println("1: Buchverwaltung");
            System.out.println("2: Studentenverwaltung");
            System.out.println("3: Ausleihen");
            System.out.println("4: Rückgabe");
            System.out.println("5: Bücherdatenbank anzeigen");
            System.out.println("6: Beenden");

            //Lese die Eingabe des Users
            separator(Styling.SEPARATOR_SIZE);
            System.out.print(Styling.YELLOW + "Eingabe: " + Styling.RESET);
            while (!scanner.hasNextInt()) {
                System.out.println(Styling.RED + "Bitte geben Sie eine Zahl ein!" + Styling.RESET);
                scanner.nextLine();
            }
            int input = scanner.nextInt();
            scanner.nextLine();
            separator(Styling.SEPARATOR_SIZE);

            switch (input) {
                case 1 -> {
                    System.out.println("1: Buch hinzufügen, 2: Buch löschen, 3: Buch bearbeiten, 4: Zurück");
                    separator(Styling.SEPARATOR_SIZE);
                    System.out.print(Styling.YELLOW + "Eingabe: " + Styling.RESET);
                    int bookInput = scanner.nextInt();
                    scanner.nextLine();
                    separator(Styling.SEPARATOR_SIZE);
                    switch (bookInput) {
                        case 1 -> {
                            boolean runningBook = true;
                            while (runningBook) {
                                userInputRequest("Geben Sie den Titel des Buches ein:");
                                String newTitle = scanner.nextLine();
                                while (newTitle.trim().isEmpty()) {
                                    userInputRequest(Styling.RED + "Der Titel darf nicht leer sein. Bitte geben Sie einen gültigen Titel ein:" + Styling.RESET);
                                    newTitle = scanner.nextLine();
                                }
                                userInputRequest("Geben Sie die Autoren des Buches ein:");
                                String newAuthors = scanner.nextLine();
                                userInputRequest("Geben Sie die ISBN des Buches ein:");
                                long newIsbn = scanner.nextLong();
                                scanner.nextLine();
                                Book newBook = new Book(newTitle, newAuthors, newIsbn, false);
                                library.addBook(newBook);

                                message(Styling.GREEN, "Buch erfolgreich hinzugefügt\n", newBook + "\n");

                                userInputRequest("Möchten Sie ein weiteres Buch hinzufügen? (y: " + Styling.GREEN + "Ja" + Styling.RESET + ", n: " + Styling.RED + "Nein" + Styling.RESET + ")", Styling.NONE, Styling.YELLOW, true);

                                String bookInput2 = scanner.nextLine();
                                separator(Styling.SEPARATOR_SIZE);

                                if (bookInput2.equals("n") || bookInput2.equals("Nein")) {
                                    runningBook = false;
                                    System.out.println("Kehre zum Hauptmenü zurück...");
                                } else if (bookInput2.equals("y") || bookInput2.equals("Ja")) {
                                    System.out.println(Styling.CYAN + "Neuer Bucheintrag:" + Styling.RESET);
                                } else {
                                    userInputRequest(Styling.RED + "Bitte geben Sie eine gültige Eingabe ein!" + Styling.RESET);
                                }
                            }
                        }
                        case 2 -> {
                            userInputRequest("Geben Sie die ID des zu löschenden Buches ein:", Styling.RESET, Styling.YELLOW, true);
                            long deleteId = scanner.nextLong();
                            scanner.nextLine();
                            separator(Styling.SEPARATOR_SIZE);
                            for (Book book : library.getAvailableBooks()) {
                                if (book.getId() == deleteId) {
                                    message(Styling.GREEN, "Gelöschtes Buch:\n", book.toString());
                                    library.removeBook(book);
                                    break;
                                } else {
                                    message(Styling.RED, "Buch nicht im System:");
                                    break;
                                }
                            }
                        }
                        case 3 -> {
                            userInputRequest("Geben Sie die ID des zu bearbeitenden Buches ein:", Styling.RESET, Styling.YELLOW, true);
                            if (!scanner.hasNextLong()) {
                                System.out.println(Styling.RED + "Es sind nur Zahlen erlaubt!" + Styling.RESET);
                                scanner.nextLine();
                                separator(Styling.SEPARATOR_SIZE, Styling.RED);
                                break;
                            }

                            long editId = scanner.nextLong();
                            scanner.nextLine();

                            Book bookToEdit = null;
                            for (Book book : library.getAvailableBooks()) {
                                if (book.getId() == editId) {
                                    bookToEdit = book;
                                    break;
                                }
                            }
                            if (bookToEdit == null) {
                                message(Styling.RED, "Kein Buch mit der gegebenen ID gefunden. Kehre zum Hauptmenü zurück...");
                            } else {
                                String tmp = "";
                                separator(Styling.SEPARATOR_SIZE, Styling.YELLOW);
                                for (Book book : library.getAvailableBooks()) {
                                    if (book.getId() == editId) {
                                        tmp = book.toString();
                                        userInputRequest(Styling.YELLOW + "Geben Sie den neuen Titel des Buches ein:" + Styling.RESET);
                                        String editTitle = scanner.nextLine();
                                        userInputRequest(Styling.YELLOW + "Geben Sie die neuen Autoren des Buches ein:" + Styling.RESET);
                                        String editAuthors = scanner.nextLine();
                                        userInputRequest(Styling.YELLOW + "Geben Sie die neue ISBN des Buches ein:" + Styling.RESET);
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
                                separator(Styling.SEPARATOR_SIZE, Styling.YELLOW);


                                message(Styling.GREEN, "Buch erfolgreich bearbeitet\n\n",
                                        Styling.YELLOW + "Vorher:  " + Styling.RESET + tmp + "\n" +
                                                Styling.GREEN + "Nachher: " + Styling.RESET + library.getBook(editId)
                                );

                            }
                        }
                        case 4 -> {
                            //return
                        }
                        default -> {
                            separator(Styling.SEPARATOR_SIZE);
                            System.out.println("Ungültige Eingabe, bitte erneut eingeben.");
                            separator(Styling.SEPARATOR_SIZE);
                        }
                    }
                }
                case 2 -> {
                    System.out.println("1: Student hinzufügen, 2: Student löschen, 3: Student anzeigen, 4: Zurück");
                    separator(Styling.SEPARATOR_SIZE);
                    System.out.print(Styling.YELLOW + "Eingabe: " + Styling.RESET);
                    int studentInput = scanner.nextInt();
                    scanner.nextLine();
                    separator(Styling.SEPARATOR_SIZE);
                    switch (studentInput) {
                        case 1 -> {
                            userInputRequest("Geben Sie den Namen des Studenten ein:");
                            String newStudentName = scanner.nextLine();
                            library.addUser(new Student(newStudentName));
                            message(Styling.GREEN, "Student erfolgreich hinzugefügt:", newStudentName);
                            separator(Styling.SEPARATOR_SIZE);
                        }
                        case 2 -> {
                            userInputRequest("Geben Sie den Namen des zu löschenden Studenten ein:");
                            String deleteStudentName = scanner.nextLine();
                            for (Student student : library.getStudents()) {
                                if (student.getName().equals(deleteStudentName)) {
                                    library.removeUser(student);
                                    message(Styling.GREEN, "Student erfolgreich gelöscht:", Styling.RED + deleteStudentName + Styling.RESET);
                                    break;
                                }
                            }
                            separator(Styling.SEPARATOR_SIZE);
                        }
                        case 3 -> {
                            boolean runningStudent = true;
                            int attempts = 0;
                            while (runningStudent) {
                                userInputRequest("Geben Sie den Namen des anzuzeigenden Studenten ein:");
                                String displayStudentName = scanner.nextLine();
                                boolean match = false;
                                for (Student student : library.getStudents()) {
                                    if (student.getName().equals(displayStudentName)) {
                                        match = true;
                                        if (student.getBorrowedBooks().size() == 0) {
                                            System.out.println(Styling.RED + "Der Student hat keine Bücher ausgeliehen." + Styling.RESET);
                                        } else {
                                            System.out.println("Der Student hat folgende Bücher ausgeliehen:");
                                            student.displayBorrowedBooks();
                                        }
                                        break;
                                    }
                                }
                                if (!match) {
                                    attempts++;
                                    if (attempts >= 3) {
                                        System.out.println(Styling.RED + "Maximale Anzahl von Versuchen erreicht.\nDer Student ist nicht im System." + Styling.RESET);
                                        runningStudent = false;
                                    } else {
                                        System.out.println(Styling.RED + "Der Student ist nicht im System. Versuchen Sie es erneut." + Styling.RESET);
                                    }
                                } else {
                                    runningStudent = false;
                                }
                            }
                            separator(Styling.SEPARATOR_SIZE);
                        }
                        case 4 -> {
                            //return
                        }
                        default -> message(Styling.RED, "Ungültige Eingabe");
                    }
                }
                case 3 -> {
                    userInputRequest("Liste aller Bücher anzeigen? [" + Styling.GREEN + "y" + Styling.RESET + "/" + Styling.RED + "n" + Styling.RESET + "]");
                    String displayBooks = scanner.nextLine();
                    if (displayBooks.equals("y")) {
                        library.displayAvailableBooks();
                    }
                    userInputRequest("Geben Sie die ID des Buches ein, das Sie ausleihen möchten:");
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
                            separator(Styling.SEPARATOR_SIZE, "\u001B[36m");
                            userInputRequest(Styling.CYAN + "Möchten Sie '" + Styling.RESET + targetBook + Styling.CYAN + "' ausleihen? " + Styling.RESET + "\n[" + Styling.GREEN + "y" + Styling.RESET + " / " + Styling.RED + "n" + Styling.RESET + "]", Styling.NONE, Styling.YELLOW, true);
                            String confirmation = scanner.nextLine();

                            if (confirmation.equalsIgnoreCase("y")) {
                                userInputRequest("Für welchen Studenten?");
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
                                    message(Styling.GREEN, "Buch erfolgreich ausgeliehen von: " + targetStudent.getName() + ".\n");

                                }
                            }
                        } else {
                            message(Styling.RED, "Buch nicht gefunden.");
                        }

                    } else {
                        message(Styling.RED, "Buch nicht verfügbar.");
                    }
                    separator(Styling.SEPARATOR_SIZE);
                }
                case 4 -> {
                    //Buch rückgabe
                    userInputRequest("Geben Sie den Namen des Studenten ein, der ein Buch zurückgeben möchte:");
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
                        targetStudent.displayBorrowedBooks();
                        userInputRequest("Geben Sie die Id des Buches ein, das zurückgegeben werden soll aus der Liste:");
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
                            message(Styling.GREEN, "Buch erfolgreich zurückgegeben von: " + targetStudent.getName());
                        }
                    }
                }
                case 5 -> {
                    library.displayAvailableBooks();
                    message(Styling.GREEN, "Insgesamt: " + Styling.GREEN + library.getBorrowedBooks() + Styling.RESET + " Bücher ausgeliehen.");
                }
                case 6 -> running = false;
                default -> message(Styling.RED, "Ungültige Eingabe");
            }
        }
    }
}
