package net.skhu.service;


import lombok.extern.slf4j.Slf4j;
import net.skhu.email.Email;
import org.springframework.lang.Nullable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Email email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        message.setSubject(email.getSubject());
        message.setSender(new InternetAddress(email.getSender()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipient()));
        message.setText(email.getContent());
        message.setSentDate(new Date());

        javaMailSender.send(message);
    }
}

