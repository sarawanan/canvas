package com.cs.canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainApplication {
    private char[][] charArray;
    private char[][] fillArray;
    boolean canvasInitiated = false;
    int width;
    int height;

    //Application entry point
    public static void main(String[] args) {
        new MainApplication().start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Enter Command : ");
                String input = scanner.nextLine();
                String command = extractCommand(input);
                List<String> params = extractParams(input);
                process(command, params);
            } while (true);
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    public String extractCommand(String input) throws InvalidCommandException {
        //Validate if input is blank
        if (input.isBlank() || input.isEmpty()) {
            throw new InvalidCommandException("Please enter valid command");
        }

        //Split the input for command & params
        String[] array = input.split(" ");
        String command = array[0].toUpperCase();

        //Validate the command
        if (!Pattern.matches("[BCLRQbclrq]", command)) {
            throw new InvalidCommandException("Only the following ['B','C','L','R','Q'] commands are valid!");
        }
        return command;
    }

    public List<String> extractParams(String input) throws InvalidCommandException {
        //Validate if input is blank
        if (input.isBlank() || input.isEmpty()) {
            throw new InvalidCommandException("Please enter valid command");
        }

        //Split the input for command & params
        String[] array = input.split(" ");
        return Arrays.asList(array).subList(1, array.length);
    }

    public void process(String command, List<String> params) throws InvalidCommandException {
        switch (command) {
            case "B" -> {
                new Fill().draw(charArray, params, height, width, fillArray);
                System.out.println(getCharArrayAsString());
            }
            case "C" -> {
                Canvas canvas = new Canvas();
                canvasInitiated = canvas.validate(params);
                width = Integer.parseInt(params.get(0));
                height = Integer.parseInt(params.get(1));
                charArray = new char[height + 2][width];
                fillArray = new char[height + 2][width];
                canvas.draw(charArray, width, height);
                System.out.println(getCharArrayAsString());
            }
            case "L" -> {
                new Line().draw(charArray, params);
                System.out.println(getCharArrayAsString());
            }
            case "R" -> {
                new Rectangle().draw(charArray, params, fillArray);
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

