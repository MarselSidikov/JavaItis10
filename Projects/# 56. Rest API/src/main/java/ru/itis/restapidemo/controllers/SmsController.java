package ru.itis.restapidemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.restapidemo.dto.SmsResultDto;
import ru.itis.restapidemo.dto.SmsResultResponseDto;
import ru.itis.restapidemo.forms.SmsForm;
import ru.itis.restapidemo.services.SmsService;

@RestController
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/sms")
    public ResponseEntity<SmsResultResponseDto> sendSms(@RequestBody SmsForm form) {
        SmsResultResponseDto responseBody = SmsResultResponseDto.builder()
                .data(smsService.sendSms(form))
                .build();
        return ResponseEntity.ok(responseBody);
    }
}
