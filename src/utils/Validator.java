package utils;

public class Validator {

    public static String validateString(String value, String fieldName) {

        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty!");
        }
        return value;
    }

    public static int validatePositive(int value, String fieldName) {

        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative!");
        }
        return value;
    }

    public static int validateRating(int value, String fieldName) {

        if (value < 0 || value > 10) {
            throw new IllegalArgumentException(fieldName + " must be between 0 and 10!");
        }
        return value;
    }
}
