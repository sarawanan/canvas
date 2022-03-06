package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRectangle {
    private Rectangle rectangle = null;

    @BeforeAll
    public void setUp() {
        rectangle = new Rectangle();
    }

    @Test()
    public void testIfRectangleIsHaving4Params() {
        List<String> params = Utils.extractParams("R");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> rectangle.validate(params)
        );
        assertEquals("Rectangle takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfRectangleParamsAreNumbers() {
        List<String> params = Utils.extractParams("R 14 1 18 A");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> rectangle.validate(params)
        );
        assertEquals("Rectangle takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfRectangleColumnsParamsAreOutOfBound() {
        List<String> params = Utils.extractParams("R 0 2 21 6");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> rectangle.draw(params)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test()
    public void testIfRectangleColumnsParamsAreOutOfBound1() {
        List<String> params = Utils.extractParams("R 14 0 18 6");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> rectangle.draw(params)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test
    public void testRectangleDraw() throws InvalidCommandException {
        Singleton singleton = Singleton.getInstance();
        singleton.width = 20;
        singleton.height = 4;
        singleton.charArray = new char[singleton.height + 2][singleton.width];
        singleton.fillArray = new char[singleton.height + 2][singleton.width];

        List<String> params = Utils.extractParams("R 14 1 18 3");
        rectangle.draw(params);
    }
}
