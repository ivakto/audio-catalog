package service.utils;

import entity.AudioItem;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

// Сортиране на всички обекти по азбучен ред или като част от playlist
public class Sort {
    public static <T extends AudioItem, R extends Comparable<R>> List<T> sort(List<T> items, Function<T, R> getter) {
        Comparator<T> comparator = Comparator.comparing(getter);

        return items.stream()
                .sorted(comparator)
                .toList();
    }
}
