package ru.itis.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncoderPasswordEncoderImpl implements Encoder {

    @Autowired
    @Qualifier("bCryptPasswordEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public void encodedRender(String message) {
        System.out.println(passwordEncoder.encode(message));
    }
}
