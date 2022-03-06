package com.cs.canvas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestShapeFactory {
    @Test
    public void testShapeFactoryReturnsCanvasType() {
        ShapeFactory factory = new ShapeFactory();
        assertTrue(factory.getShape("C") instanceof Canvas);
    }

    @Test
    public void testShapeFactoryReturnsLineType() {
        ShapeFactory factory = new ShapeFactory();
        assertTrue(factory.getShape("L") instanceof Line);
    }

    @Test
    public void testShapeFactoryReturnsFillType() {
        ShapeFactory factory = new ShapeFactory();
        assertTrue(factory.getShape("B") instanceof Fill);
    }

    @Test
    public void testShapeFactoryReturnsRectangleType() {
        ShapeFactory factory = new ShapeFactory();
        assertTrue(factory.getShape("R") instanceof Rectangle);
    }
}
