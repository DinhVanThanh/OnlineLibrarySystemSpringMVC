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
@Table(name = "MAIL")
public class Mail extends AbstractModel {
    @NotEmpty @NotNull @Column(name = "TITLE", nullable = false)
    private String title;
    @NotEmpty @NotNull @Column(name = "CONTENT", nullable = false)
    private String content;
    @Column(name = "STATUS", nullable = false)
    private boolean isReaded;

    public Mail() {
    }

    public Mail(String title, String content, boolean isReaded) {
        this.title = title;
        this.content = content;
        this.isReaded = isReaded;
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

    public boolean isReaded() {
        return isReaded;
    }

    public void setReaded(boolean readed) {
        isReaded = readed;
    }
}
