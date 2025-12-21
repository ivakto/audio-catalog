package controller;

import utils.Validator;

import java.util.Scanner;

public class InputProvider {

    private final Scanner scanner;

    public InputProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return Validator.validateString(input, prompt.replace(": ", ""));
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!");
            }
        }
    }
}
