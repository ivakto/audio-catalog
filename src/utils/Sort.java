package utils;

import entity.AudioItem;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Sort {
    public static <T extends AudioItem, R extends Comparable<R>> List<T> sort(List<T> items, Function<? super T, R> getter, boolean isAscending) {
        Comparator<T> comparator = Comparator.comparing(getter);

        if (!isAscending) {
            comparator = comparator.reversed();
        }

        return items.stream()
                .sorted(comparator)
                .toList();
    }
}
