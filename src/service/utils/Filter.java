package service.utils;

import entity.AudioItem;

import java.util.List;
import java.util.function.Function;

public class Filter {
    public static <T extends AudioItem, R> List<T> filter(List<T> items, Function<? super T, R> getter, R value) {
        return items.stream()
                .filter (item -> value.equals(getter.apply(item)))
                .toList();
    }
}

// Дай ми една функция (getter),
// която може да приеме нашия обект или негов родител (super T)
// и като свърши работа, ще върне резултат от тип (R).
// Filter.filter(library, AudioItem::getGenre, "Rock");