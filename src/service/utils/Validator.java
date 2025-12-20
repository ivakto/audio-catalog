package service.utils;

public class Validator {

    public static void validateString(String value, String fieldName) {

        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty!");
        };
    }

    public static void validatePositive(int value, String fieldName) {

        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative!");
        };
    }

    public static void validateRating(int value, String fieldName) {

        if (value < 0 || value > 10) {
            throw new IllegalArgumentException(fieldName + " must be between 0 and 10!");
        };
    }
}
