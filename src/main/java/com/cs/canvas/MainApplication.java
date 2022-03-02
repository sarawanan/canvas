package com.cs.canvas;

import com.cs.canvas.exception.InvalidCommandException;

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
                    validateInput(scanner.nextLine());
                } catch (InvalidCommandException e) {
                    e.printStackTrace();
                }
                switch (command) {
                    case "B" -> {
                        System.out.println("Solid Fill");
                    }
                    case "C" -> {
                        canvasInitiated = true;
                        int x = Integer.parseInt(this.params.get(0));
                        int y = Integer.parseInt(this.params.get(1));
                        this.charArray = new char[y + 2][x];
                        new Canvas(this.charArray, x, y);
                        System.out.println(this.getCharArrayAsString());
                    }
                    case "L" -> {
                        int x1 = Integer.parseInt(this.params.get(0));
                        int y1 = Integer.parseInt(this.params.get(1));
                        int x2 = Integer.parseInt(this.params.get(2));
                        int y2 = Integer.parseInt(this.params.get(3));
                        new Line(this.charArray, x1, y1, x2, y2);
                        System.out.println(this.getCharArrayAsString());
                    }
                    case "R" -> {
                        int x1 = Integer.parseInt(this.params.get(0));
                        int y1 = Integer.parseInt(this.params.get(1));
                        int x2 = Integer.parseInt(this.params.get(2));
                        int y2 = Integer.parseInt(this.params.get(3));
                        new Rectangle(this.charArray, x1, y1, x2, y2);
                        System.out.println(this.getCharArrayAsString());
                    }
                    case "Q" -> {
                        System.out.println("Program ends!");
                        System.exit(0);
                    }
                }
            } while (true);
        }
    }

    public String getCharArrayAsString() {
        StringBuilder results = new StringBuilder();
        for (char[] chars : charArray) {
            for (char aChar : chars) {
                results.append(aChar == 0 ? " " : aChar);
            }
            results.append("\n");
        }
        return results.toString();
    }

    private void validateInput(String input) throws InvalidCommandException {
        if (input.isBlank() || input.isEmpty()) {
            throw new InvalidCommandException("Please enter valid command");
        }

        String[] array = input.split(" ");
        this.command = array[0].toUpperCase();
        this.params = Arrays.asList(array).subList(1, array.length);

        if (!Pattern.matches("[BCLRQbclrq]", this.command)) {
            throw new InvalidCommandException("Only the following ['B','C','L','R','Q'] commands are valid!");
        }

        Pattern digits = Pattern.compile("\\d+");
        switch (this.command) {
            case "C" -> {
                if (this.params.size() != 2 || !digits.matcher(this.params.get(0)).matches()
                        || !digits.matcher(this.params.get(1)).matches()) {
                    throw new InvalidCommandException("Canvas will take 2 parameters of numbers");
                }
            }
            case "B" -> {
                if (this.params.size() != 3 || !digits.matcher(this.params.get(0)).matches()
                        || !digits.matcher(this.params.get(1)).matches()
                        || this.params.get(2).length() != 1) {
                    throw new InvalidCommandException("Solid fill take 2 parameters of numbers and last param of any char");
                }
            }
            case "L", "R" -> {
                if (this.params.size() != 4 || !digits.matcher(this.params.get(0)).matches()
                        || !digits.matcher(this.params.get(1)).matches() || !digits.matcher(this.params.get(2)).matches()
                        || !digits.matcher(this.params.get(3)).matches()) {
                    throw new InvalidCommandException("Rectangle & Line takes 4 parameters of numbers");
                }
            }
        }
    }
}

