package utils;

import java.time.LocalDate;

public class Validator {

    public static String validateString(String value, String fieldName) {

        if (value == null || value.trim().isEmpty()) {
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

    public static int validateYear(int year, String fieldName) {
        int currentYear = LocalDate.now().getYear();

        if (year < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative!");
        }
        if (year > currentYear) {
            throw new IllegalArgumentException(fieldName + " cannot be in the future! Current year is " + currentYear);
        }
        return year;
    }

    public static int validateDuration(int duration, String fieldName) {
        if (duration <= 0) {
            throw new IllegalArgumentException(fieldName + " must be greater than 0!");
        }
        return duration;
    }
}
