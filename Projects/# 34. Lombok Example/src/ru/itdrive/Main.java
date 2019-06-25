package ru.itdrive;

public class Main {

    public static void main(String[] args) {
	    User user = User.builder()
                .age(23)
                .firstName("Марсель")
                .build();

        System.out.println(user);
    }
}
