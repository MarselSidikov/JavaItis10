package ru.itis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/java_120";
    public static void main(String[] args) throws Exception {
        Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from service_user;");

        while (resultSet.next()) {
            System.out.print(resultSet.getLong("id") + " ");
            System.out.println(resultSet.getString("first_name"));
        }
    }
}
