package ru.itis.service.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class MainSQLInjection {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_120";
    public static void main(String[] args) throws Exception {
        Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();

//        Statement statement = connection.createStatement();
//        String query = "insert into service_user(first_name) values ('" + firstName + "');";
//        statement.execute(query);
//        System.out.println(query);

        PreparedStatement statement = connection.prepareStatement("insert into service_user(first_name) values (?)");
        statement.setString(1, firstName);
        statement.execute();
    }
}
