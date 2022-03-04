package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFill {
    private Fill fill = null;
    private char[][] charArray = null;
    private char[][] fillArray = null;

    @BeforeAll
    public void setUp() {
        fill = new Fill();
        charArray = new char[6][20];
        fillArray = new char[6][20];
    }

    @Test()
    public void testIfFillIsHaving3Params() throws InvalidCommandException {
        List<String> params = Utils.extractParams("B");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test()
    public void testIfFillParamsHave2Numbers() throws InvalidCommandException {
        List<String> params = Utils.extractParams("B 10 E c");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test()
    public void testIfFillParamsHave1Char() throws InvalidCommandException {
        List<String> params = Utils.extractParams("B 10 3 cc");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test
    public void testFillDraw() throws InvalidCommandException {
        List<String> params = Utils.extractParams("B 10 3 $");
        fill.draw(params, charArray, 20, 4, fillArray);
        assertEquals(charArray[2][2], '$');
    }

    @Test()
    public void testIfFillColsParamsAreOutOfBound() throws InvalidCommandException {
        List<String> params = Utils.extractParams("B 20 0 $");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.draw(params, charArray, 20, 4, fillArray)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test()
    public void testIfFillRowsParamsAreOutOfBound() throws InvalidCommandException {
        List<String> params = Utils.extractParams("B 10 5 $");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.draw(params, charArray, 20, 4, fillArray)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }
}
