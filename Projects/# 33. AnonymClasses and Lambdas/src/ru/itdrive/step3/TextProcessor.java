package ru.itdrive.step3;


import java.util.ArrayList;
import java.util.List;

public class TextProcessor {

    public List<String> reverse(List<String> lines) {
        // массив с перевернутыми строками
        List<String> result = new ArrayList<>();
        // представление текущей строки в виде массива символов
        char currentLine[];
        // смотрим каждую строку в исходном списке
        for (String line : lines) {
            // получаем массив символов из текущей строки
            currentLine = line.toCharArray();
            // создаем массив символов для развернутой строки
            // ее размер равен размеру исходной строки
            char reversedLine[] = new char[currentLine.length];

            int i = 0;
            // заполняем новый массив в обратном порядке
            for (char currentChar : currentLine) {
                reversedLine[reversedLine.length - 1 - i] = currentChar;
                i++;
            }
            String resultLine = new String(reversedLine);
            result.add(resultLine);
        }
        return result;
    }

    public void print(List<String> lines, Consumer lineOutFunction) {
        for (String line : lines) {
            lineOutFunction.apply(line);
        }
    }
}
