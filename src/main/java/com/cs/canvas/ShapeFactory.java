package com.cs.canvas;

public class ShapeFactory {
    public Shape getShape(String command) {
        Shape shape = null;
        switch (command) {
            case "C" -> shape = new Canvas();
            case "B" -> shape = new Fill();
            case "L" -> shape = new Line();
            case "R" -> shape = new Rectangle();
            case "Q" -> {
                System.out.println("Program ends!");
                System.exit(0);
            }
        }
        return shape;
    }
}
