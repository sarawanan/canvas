package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCanvas {
    private Canvas canvas = null;

    @BeforeAll
    public void setUp() {
        canvas = new Canvas();
    }

    @Test()
    public void testIfCanvasIsHaving2Params() throws InvalidCommandException {
        List<String> params = Utils.extractParams("C");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> canvas.validate(params)
        );
        assertEquals("Canvas will take 2 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfCanvasParamsAreNumbers() throws InvalidCommandException {
        List<String> params = Utils.extractParams("C 20 A");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> canvas.validate(params)
        );
        assertEquals("Canvas will take 2 parameters of numbers", thrown.getMessage());
    }

    @Test
    public void testCanvasDraw() throws InvalidCommandException {
        List<String> params = Utils.extractParams("C 20 4");
        char[][] charArray = new char[6][20];
        canvas.draw(params, charArray, 20, 4);
        assertEquals(charArray[0][0], '-');
        assertEquals(charArray[5][19], '-');
        assertEquals(charArray[1][0], '|');
        assertEquals(charArray[3][19], '|');
    }
}
