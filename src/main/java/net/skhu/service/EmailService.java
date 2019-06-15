package net.skhu.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.email.Email;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

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

