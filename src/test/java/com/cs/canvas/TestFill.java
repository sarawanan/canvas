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

    @BeforeAll
    public void setUp() {
        fill = new Fill();
    }

    @Test()
    public void testIfFillIsHaving3Params() {
        List<String> params = Utils.extractParams("B");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test()
    public void testIfFillParamsHave2Numbers() {
        List<String> params = Utils.extractParams("B 10 E c");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test()
    public void testIfFillParamsHave1Char() {
        List<String> params = Utils.extractParams("B 10 3 cc");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.validate(params)
        );
        assertEquals("Solid fill take 2 parameters of numbers and last param of any char", thrown.getMessage());
    }

    @Test()
    public void testIfFillColsParamsAreOutOfBound() {
        List<String> params = Utils.extractParams("B 20 0 $");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.draw(params)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test()
    public void testIfFillRowsParamsAreOutOfBound() {
        List<String> params = Utils.extractParams("B 10 7 $");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> fill.draw(params)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test
    public void testFillDraw() throws InvalidCommandException {
        Singleton singleton = Singleton.getInstance();
        singleton.width = 20;
        singleton.height = 4;
        singleton.charArray = new char[singleton.height + 2][singleton.width];
        singleton.fillArray = new char[singleton.height + 2][singleton.width];

        List<String> params = Utils.extractParams("B 10 3 c");
        fill.draw(params);
    }
}
