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
@Table(name = "BOOK_ORDER")
public class BookOrder extends AbstractModel {

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "BOOK_ORDER_AND_BOOK_ORDER_DETAIL", joinColumns = @JoinColumn(name = "BOOK_ORDER_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ORDER_DETAIL_ID"))
    private List<BookOrderDetail> books;
     @Column(name = "ORDER_DATE" )
    private Date orderDate;
     @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
     @JoinColumn(name = "READER_ID" )
    private Reader reader;
    @Column(name = "IS_APPROVAL")
    private boolean isApproval; //duyệt đăt mua
    @Column(name = "TOTAL_MONEY")
    private double totalMoney;
    @Column(name = "DATE_OF_APPROVAL")
    private Date dateOfApproval;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;

    public BookOrder() {
    }


    public BookOrder(List<BookOrderDetail> books, Date orderDate, Reader reader ) {
        this.books = books;
        this.orderDate = orderDate;
        this.reader = reader;
        this.isApproval = false;
    }

    public List<BookOrderDetail> getBooks() {
        return books;
    }

    public void setBooks(List<BookOrderDetail> books) {
        this.books = books;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public boolean isApproval() {
        return isApproval;
    }

    public void setApproval(boolean approval) {
        isApproval = approval;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(Date dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
