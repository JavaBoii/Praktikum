package sandboxJavaBoii;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class BookTableModel extends AbstractTableModel {
    private List<Book> books;
    private final String[] columnNames = {"ID", "Title", "Authors", "ISBN", "Is Borrowed"};

    public BookTableModel(List<Book> books) {
        this.books = books;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return books.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Book book = books.get(row);
        switch (col) {
            case 0:
                return book.getId();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthors();
            case 3:
                return book.getIsbn();
            case 4:
                return book.isBorrowed();
            default:
                throw new IllegalArgumentException("Invalid column index");
        }
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
