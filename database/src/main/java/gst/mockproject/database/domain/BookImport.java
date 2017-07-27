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
@Table(name = "BOOK_IMPORT")
public class BookImport extends AbstractModel {
    @NotEmpty @NotNull @Column(name = "DATE_IMPORT", nullable = false)
    private Date dateImport;
   @NotNull @NotEmpty @OneToMany @JoinTable(name = "IMPORTBOOK_BOOK", joinColumns = @JoinColumn(name = "IMPORT_BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private List<Book> books;
   @NotEmpty @NotNull @Column(name = "QUANTITY_IMPORT_BOOK")
   private int quantity;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;

    public BookImport() {
    }

    public BookImport(Date dateImport, List<Book> books, int quantity, Date dateModified) {
        this.dateImport = dateImport;
        this.books = books;
        this.quantity = quantity;
        this.dateModified = dateModified;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getNumber() {
        return quantity;
    }

    public void setNumber(int number) {
        this.quantity = number;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }
}
