package ru.itis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpringExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis\\context.xml");
        PrefixUtils utils = context.getBean(PrefixUtils.class);
        utils.render("Hello, World");
    }
}
