package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by dinhv on 2/7/2017.
 */
@Entity
@Table(name = "BOOK_RETURN")
public class ReturnBook extends AbstractModel {
    @NotEmpty @NotNull @ManyToOne @JoinColumn(name = "READER_ID", nullable = false)
    private Reader reader;
    @NotEmpty @NotNull @Column(name = "RETURN_DATE", nullable = false)
    private Date returnDate;
    @NotEmpty @NotNull @ManyToMany
    @JoinTable(name = "RETURNBOOK_BOOK", joinColumns = @JoinColumn(name = "RETURN_BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private List<Book> books;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;
    @OneToOne @JoinColumn(name = "BORROW_BOOK_ID")
    private BookReservation bookReservation;

    public ReturnBook() {
    }

    public ReturnBook(Reader reader, Date returnDate, List<Book> books, Date dateModified, BookReservation bookReservation) {
        this.reader = reader;
        this.returnDate = returnDate;
        this.books = books;
        this.dateModified = dateModified;
        this.bookReservation = bookReservation;
    }

    public BookReservation getBookReservation() {
        return bookReservation;
    }

    public void setBookReservation(BookReservation bookReservation) {
        this.bookReservation = bookReservation;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
