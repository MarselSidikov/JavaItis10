package ru.itis.restapidemo.forms;

import lombok.Data;

@Data
public class SmsForm {
    private String phone;
    private String text;
}
