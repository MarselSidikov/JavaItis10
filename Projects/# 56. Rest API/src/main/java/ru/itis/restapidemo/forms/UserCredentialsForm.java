package ru.itis.restapidemo.forms;

import lombok.Data;

@Data
public class UserCredentialsForm {
    private String email;
    private String password;
}
