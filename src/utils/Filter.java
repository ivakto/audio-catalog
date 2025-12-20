package utils;

import entity.AudioItem;

import java.util.List;
import java.util.function.Function;

// Условие: Филтрация на обекти по жанр, автор, година и т.н.
// Освен че ни трябват полетата на AudioItem, можем да получим и поле на подклас, затова използваме super
// Function<? super T, R> getter, R value) - приемаме функция, която знае да работи с T или с негов родител -> връща резълтат пр. getTitle()

public class Filter {
    public static <T extends AudioItem, R> List<T> filter(List<T> items, Function<? super T, R> getter, R value) {
        return items.stream()
                .filter (item -> value.equals(getter.apply(item))) // Вземи инструмента за вадене на данни (getter), който ти подадох,
                // и го използвай върху този конкретен обект (item), за да измъкнеш стойността.
                .toList();
    }
}

// Дай ми една функция (getter),
// която може да приеме нашия обект или негов родител (super T)
// и като свърши работа, ще върне резултат от тип (R).
// Filter.filter(library, AudioItem::getGenre, "Rock");