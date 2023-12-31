package com.example.taleadventure.domain.notification.controller;

import com.example.taleadventure.domain.notification.dto.RequestDto;
import com.example.taleadventure.domain.notification.service.FirebaseCloudMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final FirebaseCloudMessageService firebaseCloudMessageService;

    @PostMapping("/api/fcm")
    public ResponseEntity pushMessage(@RequestBody RequestDto requestDto) throws IOException {
        System.out.println(requestDto.getTargetToken() + " "
                +requestDto.getTitle() + " " + requestDto.getBody());

        firebaseCloudMessageService.sendMessageTo(
                requestDto.getTargetToken(),
                requestDto.getTitle(),
                requestDto.getBody());
        return ResponseEntity.ok().build();
    }
}
