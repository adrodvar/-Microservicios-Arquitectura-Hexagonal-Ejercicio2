package com.example.adapters.out.notification;

import com.example.ports.out.NotificationOutPort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;

/*
Clase ejemplo:
https://github.com/jhipster/jhipster-sample-app/blob/main/src/main/java/io/github/jhipster/sample/service/MailService.java
 */
public class EmailNotifier implements NotificationOutPort {

    private final JavaMailSender mailSender;

    public EmailNotifier(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String email, String message) {
        if(!StringUtils.hasLength(email) || !StringUtils.hasLength(message) ){
            System.out.println("Error datos incorrectos para el envío");
            return;
        }

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("support@company.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText(message);
        simpleMailMessage.setSubject("Ecommerce app notification");

        mailSender.send(simpleMailMessage);
    }
}
