package ru.itis.restapidemo.services;

import ru.itis.restapidemo.dto.SmsResultDto;
import ru.itis.restapidemo.forms.SmsForm;

public interface SmsService {
    SmsResultDto sendSms(SmsForm form);
}
