package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dinhv on 2/7/2017.
 */
@Entity
@Table(name = "RETURN_BOOK_NOTIFICATION")
public class ReturnBookNotification extends AbstractModel {
    @NotEmpty @NotNull @ManyToOne @JoinColumn(name = "BORROWER_ID")
    private Reader person;
    @NotEmpty @NotNull @Column(name = "TITLE")
    private String title;
    @NotEmpty @NotNull @Column(name = "CONTENT")
    private String content;
    @NotEmpty @NotNull @Column(name = "REMAIN_DAY")
    private short remainDay; // số ngày còn lại
    @NotEmpty @NotNull @ManyToMany
    @JoinTable(name = "RETURNBOOKNOTI_BOOK", joinColumns = @JoinColumn(name = "RETURN_BOOK_NOTI_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private List<Book> books;

    public ReturnBookNotification() {
    }

    public ReturnBookNotification(Reader person, String title, String content, short remainDay, List<Book> books) {
        this.person = person;
        this.title = title;
        this.content = content;
        this.remainDay = remainDay;
        this.books = books;
    }

    public Reader getPerson() {
        return person;
    }

    public void setPerson(Reader person) {
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(short remainDay) {
        this.remainDay = remainDay;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
