package ru.itis.tests;

import ru.itis.models.User;
import ru.itis.models.UserRole;

public class MainBuilderTest {

    public static void main(String[] args) {
        User user = User.builder() // создали объект типа Builder
                .age(25) // положили в этот объект в поле age 25
                .email("sidikov.marsel@gmail.com") // положили в этот объект email
                .firstName("Марсель") // положили в этот объект firstName
                .role(UserRole.MODERATOR)
                .build(); // создали объект User на основе объекта Builder

//        if (user.getRole().equals(UserRole.MODERATOR)) {
//            System.out.println("Модератор");
//        }

        if (user.isModerator()) {
            System.out.println("Модератор");
        }
    }
}
