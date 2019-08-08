package ru.itis;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("Marsel");
        lines.add("hello");
        lines.add("how");
        lines.add("yeah");

        // получили стрим строк
        Stream<String> linesStream = lines.stream();
        // получили стри чисел, каждое из которых
        // было получено с помощью прождения функцией map
        // каждого элемента стрима строк
        // и получением его длины
        Stream<Integer> lengthsStream = linesStream
                .map(line -> line.length());

        // преобразовали стрим в список
        List<Integer> lengthsList = lengthsStream.collect(Collectors.toList());
        // вывели список
        System.out.println(lengthsList);
        // заново получили стрим чисел
        lengthsStream = lengthsList.stream();
        // получили отфильтрованный стрим с четными элементами
        Stream<Integer> evensNumbersStream = lengthsStream
                .filter(number -> number % 2 == 0);
        // преобразовали обратно в список
        List<Integer> evensNumbersList = evensNumbersStream.collect(Collectors.toList());
        // напечатали список
        System.out.println(evensNumbersList);
        // получили заново стрим четных чисел
        evensNumbersStream = evensNumbersList.stream();
        // красиво напечатали каждое из них
        evensNumbersStream.forEach(number -> System.err.println("NUMBER = " + number));

    }
}
