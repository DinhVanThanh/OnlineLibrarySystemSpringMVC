package gst.mockproject.ui.Model;

import gst.mockproject.database.domain.Book;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by dinhv on 2/26/2017.
 */
@Component
public class ReturnBook {
    private int reader_id;
    private Date ReturnDate;
    private List<Book> books;

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
