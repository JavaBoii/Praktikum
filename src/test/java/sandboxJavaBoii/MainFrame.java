package sandboxJavaBoii;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel MainPanel = new JPanel();
    private Library library = new Library();
    String[] columnNames = {"Title", "Authors", "ISBN", "Borrowed"};
    Object[][] data = library.getBooksAsArray();
    DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return true;
        }
    };
    JTable table = new JTable(tableModel);

    JScrollPane scrollPane = new JScrollPane(table);

    public MainFrame() {
        setContentPane(MainPanel);
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set size of window to be half of the screen
        int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2);
        //if the width is too small, set it to 800 and if it's too big, set it to half of 1080p
        if (width < 800) {
            width = 800;
        } else if (width > 960) {
            width = 960;
        }
        int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
        setSize(width, height);
        //window appears in the center of the screen
        setLocationRelativeTo(null);

        //create a Menu with the options "Datei", "Buch", "Kunde", "Aktionen" and "Hilfe"
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("Datei");
        JMenu menuBook = new JMenu("Buch");
        JMenu menuStudent = new JMenu("Student");
        JMenu menuActions = new JMenu("Aktionen");
        JMenu menuHelp = new JMenu("Hilfe");
        menuBar.add(menuFile);
        menuBar.add(menuBook);
        menuBar.add(menuStudent);
        menuBar.add(menuActions);
        menuBar.add(menuHelp);
        //add the options "Import", "Export", "Beenden" to the menu "Datei"
        JMenuItem menuItemImport = new JMenuItem("Import");
        JMenuItem menuItemExport = new JMenuItem("Export");
        JMenuItem menuItemSave = new JMenuItem("Speichern");
        JMenuItem menuItemLogout = new JMenuItem("Abmelden");
        JMenuItem menuItemExit = new JMenuItem("Beenden");
        menuFile.add(menuItemImport);
        menuFile.add(menuItemExport);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemLogout);
        // Erzeugung eines Objektes der Klasse JSeparator
        JSeparator sep = new JSeparator();
        // JSeparator wird unserem JMenu hinzugefügt
        menuFile.add(sep);
        menuFile.add(menuItemExit);
        //add the options "Buch hinzufügen", "Buch bearbeiten", "Buch löschen" to the menu "Buch"
        JMenuItem menuItemAddBook = new JMenuItem("Buch hinzufügen");
        JMenuItem menuItemEditBook = new JMenuItem("Buch bearbeiten");
        JMenuItem menuItemDeleteBook = new JMenuItem("Buch löschen");
        menuBook.add(menuItemAddBook);
        menuBook.add(menuItemEditBook);
        menuBook.add(menuItemDeleteBook);
        setJMenuBar(menuBar);
        //add the options "Student hinzufügen", "Student bearbeiten", "Student löschen" to the menu "Student"
        JMenuItem menuItemAddStudent = new JMenuItem("Student hinzufügen");
        JMenuItem menuItemDeleteStudent = new JMenuItem("Student löschen");
        JMenuItem menuItemShowStudent = new JMenuItem("Student anzeigen");
        menuStudent.add(menuItemAddStudent);
        menuStudent.add(menuItemDeleteStudent);
        menuStudent.add(menuItemShowStudent);
        //add the options "Buch ausleihen", "Buch zurückgeben" to the menu "Aktionen"
        JMenuItem menuItemBorrowBook = new JMenuItem("Buch ausleihen");
        JMenuItem menuItemReturnBook = new JMenuItem("Buch zurückgeben");
        JMenuItem menuItemShowBorrowedBooks = new JMenuItem("Ausleihsystem anzeigen");
        JMenuItem menuItemShowLibrary = new JMenuItem("Bibliothek anzeigen");
        menuActions.add(menuItemBorrowBook);
        menuActions.add(menuItemReturnBook);
        menuActions.add(menuItemShowBorrowedBooks);
        menuActions.add(menuItemShowLibrary);
        //add the options "Über" to the menu "Hilfe"
        JMenuItem menuItemAbout = new JMenuItem("Über");
        menuHelp.add(menuItemAbout);
        //add a listener to the option "Beenden" to close the program
        menuItemExit.addActionListener(e -> System.exit(0));
        //add a listener to the option "Über" to show a message dialog with the information about the program
        menuItemAbout.addActionListener(e -> JOptionPane.showMessageDialog(null, "Dieses Programm wurde von Hermann und Aliwi entwickelt.", "Über", JOptionPane.INFORMATION_MESSAGE));
        menuItemAddBook.addActionListener(e -> {
            JFrame frame = new JFrame("Add Book");
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(4, 2));

            JLabel titleLabel = new JLabel("Title: ");
            JTextField titleField = new JTextField();

            JLabel authorsLabel = new JLabel("Authors: ");
            JTextField authorsField = new JTextField();

            JLabel isbnLabel = new JLabel("ISBN: ");
            JTextField isbnField = new JTextField();

            JButton submitButton = new JButton("Submit");

            panel.add(titleLabel);
            panel.add(titleField);
            panel.add(authorsLabel);
            panel.add(authorsField);
            panel.add(isbnLabel);
            panel.add(isbnField);
            panel.add(new JLabel());  // Fill grid layout
            panel.add(submitButton);

            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);

            submitButton.addActionListener(submitEvent -> {
                String title = titleField.getText();
                String authors = authorsField.getText();
                long isbn = Long.parseLong(isbnField.getText());

                Book book = new Book(title, authors, isbn, false);

                library.addBook(book, tableModel);

                frame.dispose();
            });
        });
        menuItemAddStudent.addActionListener(e -> {
            JFrame frame = new JFrame("Add Student");
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(4, 2));

            JLabel firstNameLabel = new JLabel("First Name: ");
            JTextField firstNameField = new JTextField();

            JLabel lastNameLabel = new JLabel("Last Name: ");
            JTextField lastNameField = new JTextField();

            JButton submitButton = new JButton("Submit");

            panel.add(firstNameLabel);
            panel.add(firstNameField);
            panel.add(lastNameLabel);
            panel.add(lastNameField);
            panel.add(new JLabel());  // Fill grid layout
            panel.add(submitButton);

            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);

            submitButton.addActionListener(submitEvent -> {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();

                Student student = new Student(firstName + lastName);

                library.addUser(student);

                frame.dispose();
            });
        });
        menuItemEditBook.addActionListener(e -> {
            JFrame frame = new JFrame("Edit Book");
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(4, 2));

            JLabel titleLabel = new JLabel("Title: ");
            JTextField titleField = new JTextField();

            JLabel authorsLabel = new JLabel("Authors: ");
            JTextField authorsField = new JTextField();

            JLabel isbnLabel = new JLabel("ISBN: ");
            JTextField isbnField = new JTextField();

            JButton submitButton = new JButton("Submit");

            panel.add(titleLabel);
            panel.add(titleField);
            panel.add(authorsLabel);
            panel.add(authorsField);
            panel.add(isbnLabel);
            panel.add(isbnField);
            panel.add(new JLabel());  // Fill grid layout
            panel.add(submitButton);

            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setVisible(true);

            submitButton.addActionListener(submitEvent -> {
                String title = titleField.getText();
                String authors = authorsField.getText();
                long isbn = Long.parseLong(isbnField.getText());

                Book book = new Book(title, authors, isbn, false);

                library.addBook(book);

                frame.dispose();
            });
        });
        Book book2 = new Book("Garry Lotter", "Grindewald", 2345678901L, false);
        Book book3 = new Book("Basic Chemistry", "Skyler White, Nestlé", 3456789012L, false);
        Book book4 = new Book("Buch4", "Autor6", 4567890123L, false);
        Book book5 = new Book("Buch5", "Autor7", 5678901234L, false);
        Book book6 = new Book("Intermediate Chemistry", "Skyler White, UnOwen", 6789012345L, false);
        Book book7 = new Book("Buch7", "Autor10, Autor11", 7890123456L, false);
        Book book8 = new Book("How to sell Drugs | Beginner Edition", "Autor12", 8901234567L, false);
        Book book9 = new Book("Advanced Chemistry", "Obamium, Thanos", 9012345678L, false);
        Book book10 = new Book("Buch10", "Autor15", 1234567891L, false);

        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);




        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);
        tableModel.addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                Object newValue = tableModel.getValueAt(row, column);

                // Retrieve the book and update it
                Book book = library.getBook(row);
                switch (column) {
                    case 0: // Title
                        book.setTitle((String) newValue);
                        break;
                    case 1: // Authors
                        book.setAuthors((String) newValue);
                        break;
                    case 2: // ISBN
                        book.setIsbn(Long.parseLong((String) newValue));
                        break;
                    case 3: // Borrowed
                        book.setBorrowed(Boolean.parseBoolean((String) newValue));
                        break;
                }
            }
        });
        MainPanel.add(scrollPane); // Make sure to add scrollPane to your MainPanel










        setVisible(true);
    }
}