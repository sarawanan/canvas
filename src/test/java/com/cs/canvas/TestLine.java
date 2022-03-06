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
    public void testIfLineIsHaving4Params() {
        List<String> params = Utils.extractParams("L");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.validate(params)
        );
        assertEquals("Line takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfLineParamsAreNumbers() {
        List<String> params = Utils.extractParams("L 1 2 6 A");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.validate(params)
        );
        assertEquals("Line takes 4 parameters of numbers", thrown.getMessage());
    }

    @Test()
    public void testIfLineColumnsParamsAreOutOfBound() {
        List<String> params = Utils.extractParams("L 1 2 21 2");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.draw(params)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test()
    public void testIfLineRowsParamsAreOutOfBound() {
        List<String> params = Utils.extractParams("L 4 0 4 5");
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> line.draw(params)
        );
        assertEquals("Co-ordinates out of bound", thrown.getMessage());
    }

    @Test
    public void testLine1Draw() throws InvalidCommandException {
        Singleton singleton = Singleton.getInstance();
        singleton.width = 20;
        singleton.height = 4;
        singleton.charArray = new char[singleton.height + 2][singleton.width];
        singleton.fillArray = new char[singleton.height + 2][singleton.width];

        List<String> params = Utils.extractParams("L 1 2 6 2");
        line.draw(params);
    }

    @Test
    public void testLine2Draw() throws InvalidCommandException {
        Singleton singleton = Singleton.getInstance();
        singleton.width = 20;
        singleton.height = 4;
        singleton.charArray = new char[singleton.height + 2][singleton.width];
        singleton.fillArray = new char[singleton.height + 2][singleton.width];

        List<String> params = Utils.extractParams("L 6 3 6 4");
        line.draw(params);
    }
}
