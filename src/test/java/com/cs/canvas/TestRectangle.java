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
    private MainApplication mainApplication = null;

    @BeforeAll
    public void setUp() {
        mainApplication = new MainApplication();
        rectangle = new Rectangle();
    }

    @Test()
    public void testIfRectangleIsHaving4Params() throws InvalidCommandException {
        List<String> params = mainApplication.extractParams("R");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> rectangle.validate(params)
        );
        assertEquals("Rectangle takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfRectangleParamsAreNumbers() throws InvalidCommandException {
        List<String> params = mainApplication.extractParams("R 14 1 18 A");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> rectangle.validate(params)
        );
        assertEquals("Rectangle takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test
    public void testRectangleDraw() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        char[][] fillArray = new char[6][20];
        List<String> params = mainApplication.extractParams("R 14 1 18 3");
        rectangle.draw(charArray, params, fillArray, 20, 4);
        assertEquals(charArray[1][13], 'x');
        assertEquals(charArray[3][17], 'x');
    }

    @Test()
    public void testIfRectangleColumnsParamsAreOutOfBound() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        char[][] fillArray = new char[6][20];
        List<String> params = mainApplication.extractParams("R 0 2 21 6");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> rectangle.draw(charArray, params, fillArray, 20, 4)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }
}
