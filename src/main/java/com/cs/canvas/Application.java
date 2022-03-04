package com.cs.canvas;

import java.util.List;
import java.util.Scanner;

import static com.cs.canvas.Utils.extractCommand;
import static com.cs.canvas.Utils.extractParams;

public class Application {
    protected char[][] charArray;
    protected char[][] fillArray;
    protected boolean canvasInitiated = false;
    protected int width;
    protected int height;

    //Application entry point
    public static void main(String[] args) {
        new Application().start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Enter Command : ");
                String input = scanner.nextLine();
                try {
                    process(input);
                } catch (InvalidCommandException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    public void process(String input) throws InvalidCommandException {
        final List<String> params = extractParams(input);

        switch (extractCommand(input)) {
            case "C" -> {
                width = Integer.parseInt(params.get(0));
                height = Integer.parseInt(params.get(1));
                charArray = new char[height + 2][width];
                fillArray = new char[height + 2][width];
                new Canvas().draw(params, charArray, width, height);
                canvasInitiated = true;
                System.out.println(getCharArrayAsString());
            }
            case "B" -> {
                if (!canvasInitiated) {
                    throw new InvalidCommandException("First initialize the canvas");
                }
                new Fill().draw(params, charArray, width, height, fillArray);
                System.out.println(getCharArrayAsString());
            }
            case "L" -> {
                if (!canvasInitiated) {
                    throw new InvalidCommandException("First initialize the canvas");
                }
                new Line().draw(params, charArray, width, height);
                System.out.println(getCharArrayAsString());
            }
            case "R" -> {
                if (!canvasInitiated) {
                    throw new InvalidCommandException("First initialize the canvas");
                }
                new Rectangle().draw(params, charArray, width, height, fillArray);
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
