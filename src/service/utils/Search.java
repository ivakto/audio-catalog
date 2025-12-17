package service.utils;

import entity.AudioItem;

import java.util.List;
import java.util.function.Function;


public class Search {
    public static <T extends AudioItem> List <T> search(List<T> items, Function<T, String> getter, String searchTerm){
        if (searchTerm == null || searchTerm.isEmpty()) {
            return items;
        }

        return items.stream()
                .filter(item -> getter.apply(item).toLowerCase().contains(searchTerm.toLowerCase()))
                .toList();

    }
}
