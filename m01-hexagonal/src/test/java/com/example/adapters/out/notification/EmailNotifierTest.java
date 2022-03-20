package com.example.adapters.out.notification;

import com.example.ports.out.NotificationOutPort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailNotifierTest {

    @Autowired
    private NotificationOutPort notifier;

    @Test
    void sendEmail() {
        this.notifier.sendEmail("example@example.com", "Hola mundo desde Spring!!");
    }
}