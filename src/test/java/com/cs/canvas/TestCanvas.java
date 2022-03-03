package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCanvas {
    private Canvas canvas = null;
    private MainApplication mainApplication = null;

    @BeforeAll
    public void setUp() {
        mainApplication = new MainApplication();
        canvas = new Canvas();
    }

    @Test()
    public void testIfCanvasIsHaving2Params() throws InvalidCommandException {
        List<String> params = mainApplication.extractParams("C");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> canvas.validate(params)
        );
        assertEquals("Canvas will take 2 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfCanvasParamsAreNumbers() throws InvalidCommandException {
        List<String> params = mainApplication.extractParams("C 20 A");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> canvas.validate(params)
        );
        assertEquals("Canvas will take 2 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfCanvasParamsAreValid() throws InvalidCommandException {
        List<String> params = mainApplication.extractParams("C 20 4");
        assertTrue(canvas.validate(params));
    }

    @Test
    public void testCanvasDraw() {
        char[][] charArray = new char[6][20];
        canvas.draw(charArray, 20, 4);
        assertEquals(charArray[0][0], '-');
        assertEquals(charArray[5][19], '-');
        assertEquals(charArray[1][0], '|');
        assertEquals(charArray[3][19], '|');
    }
}
