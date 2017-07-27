package gst.mockproject.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
/**
 * Created by Kama on 3/26/2017.
 */
@Service
@ComponentScan(basePackages = "gst.mockproject.service.service")
public class EmailService {
    @Autowired
    private  JavaMailSenderImpl javaMailSender;

    private String sender;
    private String receiver;
    private String subject;
    private String content;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void sendEmail() {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(this.sender);
            messageHelper.setTo(this.receiver);
            messageHelper.setSubject(this.subject);
            messageHelper.setText(this.content);
        };
        javaMailSender.setPort(465);
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setUsername("trainingkama@gmail.com");
        javaMailSender.setPassword("Test123456");
        javaMailSender.setProtocol("smtps");
        javaMailSender.send(messagePreparator);
    }
}
