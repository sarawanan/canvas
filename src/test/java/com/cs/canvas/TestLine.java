package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLine {
    private Line line = null;
    private MainApplication mainApplication = null;

    @BeforeAll
    public void setUp() {
        mainApplication = new MainApplication();
        line = new Line();
    }

    @Test()
    public void testIfLineIsHaving4Params() throws InvalidCommandException {
        List<String> params = mainApplication.extractParams("L");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.validate(params)
        );
        assertEquals("Line takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfLineParamsAreNumbers() throws InvalidCommandException {
        List<String> params = mainApplication.extractParams("L 1 2 6 A");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.validate(params)
        );
        assertEquals("Line takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfLineColumnsParamsAreOutOfBound() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        List<String> params = mainApplication.extractParams("L 1 2 21 2");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.draw(charArray, params, 20, 4)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test()
    public void testIfLineRowsParamsAreOutOfBound() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        List<String> params = mainApplication.extractParams("L 4 0 4 5");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.draw(charArray, params, 20, 4)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test
    public void testLineDraw() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        List<String> params = mainApplication.extractParams("L 1 2 6 2");
        line.draw(charArray, params, 20, 4);
        assertEquals(charArray[2][1], 'x');
        assertEquals(charArray[2][6], 'x');
    }
}
