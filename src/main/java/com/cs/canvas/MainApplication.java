    package com.cs.canvas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainApplication {
    private String command;
    private List<String> params;
    private char[][] charArray;
    boolean canvasInitiated = false;

    //Application entry point
    public static void main(String[] args) {
        new MainApplication().readCommand();
    }

    private void readCommand() {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                //TODO implement clear console function here
                System.out.print("Enter Command : ");
                try {
                    //Take the input
                    String input = scanner.nextLine();

                    //Validate if input is blank
                    if (input.isBlank() || input.isEmpty()) {
                        throw new InvalidCommandException("Please enter valid command");
                    }

                    //Split the input for command & params
                    String[] array = input.split(" ");
                    command = array[0].toUpperCase();
                    params = Arrays.asList(array).subList(1, array.length);

                    //Validate the command
                    if (!Pattern.matches("[BCLRQbclrq]", command)) {
                        throw new InvalidCommandException("Only the following ['B','C','L','R','Q'] commands are valid!");
                    }

                    handleCommand();
                } catch (InvalidCommandException e) {
                    e.printStackTrace();
                }

            } while (true);
        }
    }

    private void handleCommand() throws InvalidCommandException {
        switch (command) {
            case "B" -> {
                new Fill().draw(charArray, params);
                System.out.println(getCharArrayAsString());
            }
            case "C" -> {
                Canvas canvas = new Canvas();
                canvasInitiated = canvas.validate(params);
                int x = Integer.parseInt(params.get(0));
                int y = Integer.parseInt(params.get(1));
                charArray = new char[y + 2][x];
                canvas.draw(charArray, x, y);
                System.out.println(getCharArrayAsString());
            }
            case "L" -> {
                new Line().draw(charArray, params);
                System.out.println(getCharArrayAsString());
            }
            case "R" -> {
                new Rectangle().draw(charArray, params);
                System.out.println(getCharArrayAsString());
            }
            case "Q" -> {
                System.out.println("Program ends!");
                System.exit(0);
            }
        }
    }

    private String getCharArrayAsString() {
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

