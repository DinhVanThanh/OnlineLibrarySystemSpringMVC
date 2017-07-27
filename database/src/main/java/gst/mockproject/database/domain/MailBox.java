package gst.mockproject.database.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dinhv on 2/5/2017.
 */
@Entity
@Table(name = "MAIL_BOX")
public class MailBox extends AbstractModel {
    @OneToMany @JoinTable(name = "MAILBOX_MAIL", joinColumns = @JoinColumn(name = "MAIL_BOX_ID"), inverseJoinColumns = @JoinColumn(name = "MAIL_ID"))
    private List<Mail> mails;
    public MailBox() {
    }

    public MailBox(List<Mail> mails) {
        this.mails = mails;
    }

    public List<Mail> getMails() {
        return mails;
    }

    public void setMails(List<Mail> mails) {
        this.mails = mails;
    }
}
