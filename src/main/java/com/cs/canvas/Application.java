package com.cs.canvas;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    System.out.print("Enter Command : ");
                    String input = scanner.nextLine();
                    Shape shape = new ShapeFactory().getShape(Utils.extractCommand(input));
                    System.out.println(shape.draw(Utils.extractParams(input)));
                } catch (InvalidCommandException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }
}
