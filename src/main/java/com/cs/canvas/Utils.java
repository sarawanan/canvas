package com.cs.canvas;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class Utils {
    public static List<String> extractParams(String input) throws InvalidCommandException {
        //Validate if input is blank
        if (input.isBlank() || input.isEmpty()) {
            throw new InvalidCommandException("Please enter valid command");
        }

        //Split the input for command & params
        final String[] array = input.split(" ");
        return Arrays.asList(array).subList(1, array.length);
    }

    public static String extractCommand(String input) throws InvalidCommandException {
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
}
