package org.nttdata.com.servicionotificaciones.controller;

import lombok.RequiredArgsConstructor;
import org.nttdata.com.servicionotificaciones.util.MainManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestMailController {
    private final MainManager mainManager;
    @PostMapping("/send-test-mail")
    public ResponseEntity<?> sendTestMail() {
        mainManager.sendMessage("franklincarpioa@gmail.com", "Test Subject", "This is a test email body.");
        return ResponseEntity.ok("Test email sent successfully.");
    }
}
