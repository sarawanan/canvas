package com.cs.canvas;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws InvalidCommandException {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.print("Enter Command : ");
                String input = scanner.nextLine();
                Shape shape = new ShapeFactory().getShape(Utils.extractCommand(input));
                System.out.println(shape.draw(Utils.extractParams(input)));
            } while (true);
        }
    }
}
