package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLine {
    private Line line = null;

    @BeforeAll
    public void setUp() {
        line = new Line();
    }

    @Test()
    public void testIfLineIsHaving4Params() throws InvalidCommandException {
        List<String> params = Utils.extractParams("L");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.validate(params)
        );
        assertEquals("Line takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfLineParamsAreNumbers() throws InvalidCommandException {
        List<String> params = Utils.extractParams("L 1 2 6 A");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.validate(params)
        );
        assertEquals("Line takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfLineColumnsParamsAreOutOfBound() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        List<String> params = Utils.extractParams("L 1 2 21 2");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.draw(params, charArray, 20, 4)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test()
    public void testIfLineRowsParamsAreOutOfBound() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        List<String> params = Utils.extractParams("L 4 0 4 5");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.draw(params, charArray, 20, 4)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test
    public void testLineDraw() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        List<String> params = Utils.extractParams("L 1 2 6 2");
        line.draw(params, charArray, 20, 4);
        assertEquals(charArray[2][1], 'x');
        assertEquals(charArray[2][6], 'x');
    }

    @Test
    public void testLineDraw1() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        List<String> params = Utils.extractParams("L 6 3 6 4");
        line.draw(params, charArray, 20, 4);
        assertEquals(charArray[3][6], 'x');
        assertEquals(charArray[4][6], 'x');
    }
}
