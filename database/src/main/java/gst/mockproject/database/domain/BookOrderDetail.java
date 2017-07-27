package gst.mockproject.database.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dinhv on 3/9/2017.
 */
@Entity
@Table(name = "BOOK_ORDER_DETAIL")
public class BookOrderDetail extends AbstractModel {
    @Column(name = "BOOK_DETAIL_TITLE" )
    private String title;

    @Column(name = "BOOK_DETAIL_CATEGORY" )
    private String category;

    @Column(name = "BOOK_DETAIL_PUBLISHER" )
    private String publisher;

    @Column(name = "BOOK_DETAIL_AUTHOR")
    private String author;

    @Column(name = "BOOK_DETAIL_QUANTITY" )
    private Integer quantity;


    public BookOrderDetail() {
    }

    public BookOrderDetail(String title, String category, String publisher, String author, Integer quantity ) {
        this.title = title;
        this.category = category;
        this.publisher = publisher;
        this.author = author;
        this.quantity = quantity;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
