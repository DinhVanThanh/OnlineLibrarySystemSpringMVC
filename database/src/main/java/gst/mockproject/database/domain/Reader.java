package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by dinhv on 2/5/2017.
 */
@Entity
@Table(name = "READER")
public class Reader extends AbstractModel {
     @Column(name = "NAME" )
    private String name;
     @Column(name = "PHONENUMBER" )
    private String phoneNumber;
    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;
     @Column(name = "READER_ADDRESS")
    private String address;
    @Column(name = "SEX")
    private String sex;
    @OneToOne @JoinColumn(name = "MAILBOX_ID" )
    private MailBox mailBox;
      @Column(name = "EMAIL" )
    private String email;
     @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
     @JoinColumn(name = "TYPEUSER_ID")
    private ReaderType readerType ;
    @NotEmpty @NotNull @Column(name = "READER_CODE")
    private String readerCode;
    @Column(name = "DATE_CREATION")
    private Date dateCreation;
    @Column(name = "DATE_MODIFIED")
    private Date dateModified;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "reader")
//    @JoinTable(name = "BOOK_RESERVATION_READER", joinColumns = @JoinColumn(name = "READER_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_RESERVATION_ID"))
    private List<BookReservation> bookReservationList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "reader")
//    @JoinTable(name = "BOOK_ORDER_READER", joinColumns = @JoinColumn(name = "READER_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ORDER_ID"))
    private List<BookOrder> bookOrderList;


    public Reader() {
    }

    public Reader(String name, String phoneNumber, Date birthDay, String address,
                  String sex, String email, ReaderType readerType, String readerCode,
                  List<BookReservation> bookReservationList, List<BookOrder> bookOrderList) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
        this.sex = sex;
        this.email = email;
        this.readerType = readerType;
        this.readerCode = readerCode;
        this.bookReservationList = bookReservationList;
        this.bookOrderList = bookOrderList;
    }

    public List<BookReservation> getBookReservationList() {
        return bookReservationList;
    }

    public void setBookReservationList(List<BookReservation> bookReservationList) {
        this.bookReservationList = bookReservationList;
    }

    public List<BookOrder> getBookOrderList() {
        return bookOrderList;
    }

    public void setBookOrderList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }

    public String getReaderCode() {
        return readerCode;
    }

    public void setReaderCode(String readerCode) {
        this.readerCode = readerCode;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public MailBox getMailBox() {
        return mailBox;
    }

    public void setMailBox(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
