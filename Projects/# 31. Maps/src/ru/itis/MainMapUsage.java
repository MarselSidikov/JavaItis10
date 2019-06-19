package ru.itis;

import java.io.BufferedReader;
import java.io.FileReader;

public class MainMapUsage {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> users = new MapEntriesArrayImpl<>();

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        String currentLine = reader.readLine();
        while (currentLine != null) {
            // получили имя
            String name = currentLine.split(" ")[0];
            int count = 0;
            if (users.containsKey(name)) {
                count = users.get(name);
            }
            count++;
            users.put(name, count);
            currentLine = reader.readLine();
        }

        int i = 0;
    }
}
