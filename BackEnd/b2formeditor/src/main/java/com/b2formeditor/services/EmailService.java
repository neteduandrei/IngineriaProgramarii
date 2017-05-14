package com.b2formeditor.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Dorneanu Dragos-Andrei on 14.05.2017.
 */
@Service
public class EmailService {

    private class EmailAuthenticator extends Authenticator {
        private String email, password;

        public EmailAuthenticator(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(email, password);
        }
    }

    public void sendFormResponseNotification(String destination, String formTitle) {
        Properties systemProperties = System.getProperties();
        Session session;
        MimeMessage emailMessage;

        systemProperties.setProperty("mail.smtp.auth", "true");
        systemProperties.setProperty("mail.smtp.starttls.enable", "true");
        systemProperties.setProperty("mail.smtp.host", "smtp.gmail.com");
        systemProperties.setProperty("mail.smtp.port", "587");
        session = Session.getDefaultInstance(systemProperties, new EmailAuthenticator("b2formeditor@gmail.com", "b2ipuaic"));
        emailMessage = new MimeMessage(session);
        sendEmail(emailMessage, destination, formTitle);
    }

    private void sendEmail(MimeMessage message, String destination, String formTitle) {
        try {
            message.setFrom(new InternetAddress("b2formeditor@gmail.com"));
            message.setSubject("Someone completed your form");
            message.setText("You are receiving this because you are the owner of the form called \"" +
                            formTitle + "\" that has just been completed.\n" +
                            "Check more information about your forms status on http://89.203.249.188:4200/");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destination));
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
