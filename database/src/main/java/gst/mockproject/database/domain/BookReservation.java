package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dinhv on 2/7/2017.
 */
@Entity
@Table(name = "BOOK_BORROW")
public class BookReservation extends AbstractModel {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "READER_ID")
    private Reader reader;
    @ManyToMany
    @JoinTable(name = "BORROWEDBOOK_BOOK", joinColumns = @JoinColumn(name = "BORROWEDBOOK_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private List<Book> books;
    @Column(name = "BORROW_DATE" )
    private Date borrowDate;
    @Column(name = "RETURN_DATE" )
    private Date returnDate;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;
    @Column(name = "STATUS")
    private boolean status;
     

    public BookReservation() {
    }

    public BookReservation(Reader reader, List<Book> books, Date borrowDate, Date returnDate, Date dateModified, boolean status) {
        this.reader = reader;
        this.books = books;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.dateModified = dateModified;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
