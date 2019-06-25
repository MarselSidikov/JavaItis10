package ru.itdrive.step4;

import java.util.ArrayList;
import java.util.List;

public class ListsProcessor{

    // функция принимает на вход
    // какую-то функцию, которая отображет
    // объекты типа T в объекты типа R
    // и возвращает список таких объектов
    public <T, R> List<R> map(List<T> elements, Function<T, R> function) {
        // создаем список для результатов
        List<R> results = new ArrayList<>();
        // проходим по всем элементам исходного списка
        for (T source : elements) {
            // к каждому элементу применяем функцию
            R result = function.apply(source);
            // кладем результат в список
            results.add(result);
        }
        // возвращаем список результатов
        return results;
    }

    public <T> List<T> filter(List<T> elements, Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return filtered;
    }

    public <T> void forEach(List<T> elements, Consumer<T> consumer) {
        for (T element : elements) {
            consumer.apply(element);
        }
    }
}
