package ru.itis.repositories;

import java.io.*;

// класс, генерирующий идентификаторы
// гарантируется, что все сгенерированные идентификаторы будут уникальными
// потому что правило генерации строится таким образом, что
// берется из файла последний сгенерированный id и к нему прибавляется 1
// далее этот id снова записывается в файл
public class IdGenerator {
    // поле, которе хранит название файла
    // в котором находится последний сгенерированный id
    private String fileName;

    public IdGenerator(String fileName) {
        this.fileName = fileName;
    }
    // функция, генерирующая новый идентификатор
    public int generate() {
        try {
            // открываем файлс последним сгенерированным id
            InputStream input = new FileInputStream(fileName);
            // создаем массив байт, куда запишем число, находящееся в файле
            byte bytes[] = new byte[10];
            // читаем набор байтов из файла
            input.read(bytes);
            // преобразуем данный набор в строку
            String idAsString = new String(bytes);
            // очищаем строку от мусора и конвертируем в число int
            int lastGeneratedId = Integer.parseInt(idAsString.trim());
            // увеличиваем данное число на 1
            lastGeneratedId++;
            // закрываем файл для чтения
            input.close();
            // открываем файл для записи
            OutputStream output = new FileOutputStream(fileName);
            // преобразуем число в строку
            idAsString = String.valueOf(lastGeneratedId);
            // конвертируем строку в массив байтов и записываем в файл
            output.write(idAsString.getBytes());
            // закрываем файл
            output.close();
            // возвращаем сгенерированный id
            return lastGeneratedId;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
