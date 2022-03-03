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
    private MainApplication application = null;

    @BeforeAll
    public void setUp() {
        application = new MainApplication();
        fill = new Fill();
    }

    @Test()
    public void testIfFillIsHaving3Params() throws InvalidCommandException {
        List<String> params = application.extractParams("B");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test()
    public void testIfFillParamsHave2Numbers() throws InvalidCommandException {
        List<String> params = application.extractParams("B 10 E c");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test()
    public void testIfFillParamsHave1Char() throws InvalidCommandException {
        List<String> params = application.extractParams("B 10 3 cc");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test
    public void testFillDraw() throws InvalidCommandException {
        char[][] charArray = new char[6][20];
        char[][] fillArray = new char[6][20];
        List<String> params = application.extractParams("B 10 3 $");
        fill.draw(charArray, params, 4, 20, fillArray);
        assertEquals(charArray[2][2], '$');
    }
}
