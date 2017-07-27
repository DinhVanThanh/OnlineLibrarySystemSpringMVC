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
@Table(name = "AUTHOR")
public class Author extends AbstractModel {

    @NotEmpty @NotNull @Column(name = "AUTHOR_NAME", unique = true, nullable = false)
    private String authorName;

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
