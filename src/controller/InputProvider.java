package controller;

import utils.Validator;

import java.util.Scanner;

public class InputProvider {

    private final Scanner scanner;

    public InputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                String fieldName = prompt.replace(": ", "").trim();
                return Validator.validateString(input, fieldName);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                int value = Integer.parseInt(input);
                String fieldName = prompt.replace(": ", "").trim();
                return Validator.validatePositive(value, fieldName);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    public int readRating(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                int value = Integer.parseInt(input);
                String fieldName = prompt.replace(": ", "").trim();
                return Validator.validateRating(value, fieldName);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    public int readReleaseYear(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                int value = Integer.parseInt(input);
                String fieldName = prompt.replace(": ", "").trim();

                return Validator.validateYear(value, fieldName);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid year number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    public int readDuration(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                int value = Integer.parseInt(input);
                String fieldName = prompt.replace(": ", "").trim();
                return Validator.validateDuration(value, fieldName);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }
}
