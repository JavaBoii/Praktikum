package zettel_3;

import java.util.ArrayList;
import java.util.List;

    public class Library {
        private List<Book> availableBooks;
        private List<Student> students;

        public Library() {
            this.availableBooks = new ArrayList<>();
            this.students = new ArrayList<>();
        }

        public void addBook(Book book) {
            availableBooks.add(book);
        }

        public void addUser(Student student) {
            students.add(student);
        }

        public void returnBook(Student student, Book book) {
            student.removeBook(book);
            availableBooks.add(book);
        }

        public void displayAvailableBooks() {
            for (Book book : availableBooks) {
                System.out.println(book.toString());
            }
        }

        public boolean isBookAvailable(Book book) {
            return availableBooks.contains(book);
        }

        public boolean isBookAvailable(String title) {
            for (Book book : availableBooks) {
                if (book.getTitle().equals(title)) {
                    return true;
                }
            }
            return false;
        }
    }


