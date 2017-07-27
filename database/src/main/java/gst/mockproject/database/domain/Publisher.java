package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by dinhv on 2/5/2017.
 */
@Entity
@Table(name = "PUBLISHER")
public class Publisher extends AbstractModel {
    @NotEmpty @NotNull @Column(name = "PUBLISHER_NAME", nullable = false, unique = true)
    private String publisherName;
    @Column(name = "PUBLISHER_PHONENUMBER")
    private String phoneNumber;
    @Column(name = "PUBLISHER_ADDRESS")
    private String address;
    @Column(name = "PUBLISHER_EMAIL")
    private String email;

    public Publisher() {
    }

    public Publisher(String publisherName, String phoneNumber, String address, String email) {
        this.publisherName = publisherName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
