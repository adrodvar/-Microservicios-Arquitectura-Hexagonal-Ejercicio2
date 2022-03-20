package com.example.config;

import com.example.adapters.out.notification.EmailNotifier;
import com.example.ports.out.NotificationOutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class SmtpConfig {

    @Bean
    public NotificationOutPort notificationOutPort(JavaMailSender mailSender){
        return new EmailNotifier(mailSender);
    }

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("localhost");
        mailSender.setPort(2525);
//        mailSender.setUsername("");
//        mailSender.setPassword("");
        mailSender.setProtocol("smtp");
        return mailSender;
    }
}
