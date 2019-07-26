package ru.itis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PrefixUtils prefixUtils = context.getBean(PrefixUtils.class);
        prefixUtils.render("Hello!");
    }
}
