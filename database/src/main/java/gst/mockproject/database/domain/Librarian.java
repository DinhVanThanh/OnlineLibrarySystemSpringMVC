package gst.mockproject.database.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by dinhv on 2/7/2017.
 */
@Entity
@Table(name = "LIBRARIAN")
public class Librarian extends Reader {
    @NotNull @NotEmpty @Column(name = "LIBRARIAN_CODE", unique = true, nullable = false)
    private String librarianCode;

    public Librarian() {
    }

    public Librarian(String librarianCode) {
        this.librarianCode = librarianCode;
    }

    public String getLibrarianCode() {
        return librarianCode;
    }

    public void setLibrarianCode(String librarianCode) {
        this.librarianCode = librarianCode;
    }
}
