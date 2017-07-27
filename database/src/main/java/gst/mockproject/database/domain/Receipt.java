package gst.mockproject.database.domain;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by dinhv on 2/7/2017.
 */
@Entity
@Table(name = "RECEIPT")
public class Receipt extends AbstractModel {
    @OneToOne @JoinColumn(name = "BOOK_ORDER_ID")
    private BookOrder bookOrder;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @ManyToOne @JoinColumn(name = "LIBRARIAN_ID")
    private Librarian librarian;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;
    @Column(name = "RECEIPT_STATUS")
    private String status;

    public Receipt() {
    }

    public Receipt(BookOrder bookOrder, Date createDate, Librarian librarian) {
        this.bookOrder = bookOrder;
        this.createDate = createDate;
        this.librarian = librarian;
        this.status = "mới tạo";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public BookOrder getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }
}
