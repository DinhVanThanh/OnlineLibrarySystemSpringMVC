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
@Table(name = "HELP")
public class Help extends AbstractModel {
    @NotEmpty @NotNull @Column(name = "TITLE", nullable = false, unique = true)
    private String title;
    @NotEmpty @NotNull @Column(name = "CONTENT", nullable = false, unique = true)
    private String content;

    public Help() {
    }

    public Help(String title, String content) {
        this.title = title;
        this.content = content;
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
}
