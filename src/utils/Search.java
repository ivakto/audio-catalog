package utils;

import entity.AudioItem;

import java.util.List;
import java.util.function.Function;

// Търсене на обект по заглавие, изпълнител, жанр и т.н.
public class Search {
    public static <T extends AudioItem, R> List <T> search(List<T> items, Function<T, R> getter, String searchTerm){

        Validator.validateString(searchTerm, "Search term");

        String searchTermLowerC = searchTerm.toLowerCase();

        return items.stream()
                .filter(item -> {
                    R value = getter.apply(item);
                    return value.toString().toLowerCase().contains(searchTermLowerC);
                })
                .toList();
    }
}
