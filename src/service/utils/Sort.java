package service.utils;

import entity.AudioItem;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static <T extends AudioItem> void sort(List<T> items, Comparator<T> rule) {
        items.sort(rule);
    }
}
