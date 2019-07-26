package ru.itis.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MainPlain {
    public static void main(String[] args) {
//        // PasswordEncoder - интерфейс Spring
//        // для хеширования паролей
//        // BCryptPasswordEncoder - конкретная реализация от Spring для
//        // Хеширования паролей методом BCrypt
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        // Encoder - наш интерфейс, который описывает поведение
//        // преобразования строки
//        // EncoderPasswordEncoderImpl - наша реализация Encoder
//        // имеет зависимость на PasswordEncoder, следовательно
//        // преобразует строку по какому-то криптографическому алгоритму
//        Encoder encoder = new EncoderPasswordEncoderImpl(passwordEncoder);
//        // MessageRenderer - для вывода сообщений
//        // позволяет также вывести сообщение в преобразованном виде
//        // через Encoder, который мы реализовали
//        MessageRenderer renderer = new MessageRendererRedImpl(encoder);
//        PrefixUtils prefixUtils = new LocalDatePrefixUtilsImpl(renderer);
//        prefixUtils.render("Hello!");
    }
}
