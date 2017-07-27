package gst.mockproject.database.domain;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by dinhv on 2/5/2017.
 */
@Entity
@Table(name = "BOOK")
public class Book extends AbstractModel {

    @Column(name = "TITLE", unique = true )
    private String title;
    @ManyToOne(cascade = javax.persistence.CascadeType.PERSIST)
    @JoinColumn(name = "CATEGORY_ID" )
    private Category category;
    @ManyToOne(cascade = javax.persistence.CascadeType.PERSIST)
    @JoinColumn(name = "PUBLISHER_ID" )
    private Publisher publisher;
    @ManyToMany(cascade = {javax.persistence.CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = @JoinColumn(name = "BOOK_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    private List<Author> author;
    @Column(name = "PRICE" )
    private Integer price;
    @Column(name = "QUANTITY" )
    private Integer quantity;
    @Column(name = "EDITION")
    private Integer edition;
    @Column(name = "BOOK_STATUS")
    private String status;
    @Column(name = "BOOK_IMAGE")
    private String image;
    @Column(name = "DATE_CREATION")
    private Date dateCreation;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;

    public Book() {
    }

    public Book(String title, Category category, Publisher publisher, List<Author> author, Integer price, Integer quantity, Integer edition ) {
        this.title = title;
        this.category = category;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.edition = edition;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (category != null ? !category.equals(book.category) : book.category != null) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (quantity != null ? !quantity.equals(book.quantity) : book.quantity != null) return false;
        if (edition != null ? !edition.equals(book.edition) : book.edition != null) return false;
        if (status != null ? !status.equals(book.status) : book.status != null) return false;
        if (image != null ? !image.equals(book.image) : book.image != null) return false;
        if (dateCreation != null ? !dateCreation.equals(book.dateCreation) : book.dateCreation != null) return false;
        return dateModified != null ? dateModified.equals(book.dateModified) : book.dateModified == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (edition != null ? edition.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}

