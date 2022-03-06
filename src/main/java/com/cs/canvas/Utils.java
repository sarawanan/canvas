package com.cs.canvas;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

final class Utils {
    static String extractCommand(String input) throws InvalidCommandException {
        //Validate if input is blank
        if (input.isBlank() || input.isEmpty()) {
            throw new InvalidCommandException("Please enter valid command");
        }

        //Split the input for command & params
        final String command = input.split(" ")[0].toUpperCase();

        //Validate the command
        if (!Pattern.matches("[BCLRQbclrq]", command)) {
            throw new InvalidCommandException("Only the following ['B','C','L','R','Q'] commands are valid!");
        }
        return command;
    }

    static List<String> extractParams(String input) {
        //Split the input for command & params
        final String[] array = input.split(" ");
        return Arrays.asList(array).subList(1, array.length);
    }

    static String getCharArrayAsString(char[][] charArray) {
        StringBuilder results = new StringBuilder();
        for (char[] chars : charArray) {
            for (char aChar : chars) {
                results.append(aChar == 0 ? " " : aChar);
            }
            results.append("\n");
        }
        return results.toString();
    }
}
