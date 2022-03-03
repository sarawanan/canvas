package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMainApplication {
    private MainApplication application = null;

    @BeforeAll
    public void setUp() {
        application = new MainApplication();
    }

    @Test()
    public void testIfInputIsBlank() {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> application.extractCommand("")
        );
        assertEquals("Please enter valid command", thrown.getMessage());
    }

    @Test()
    public void testInvalidCommand() {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> application.extractCommand("X")
        );
        assertEquals("Only the following ['B','C','L','R','Q'] commands are valid!", thrown.getMessage());
    }

    @Test()
    public void testValidCommand() throws InvalidCommandException {
        String command = application.extractCommand("C 20 4");
        assertEquals("C", command);
    }

    @Test
    public void testValidParams() throws InvalidCommandException {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> application.extractParams("")
        );
        assertEquals("Please enter valid command", thrown.getMessage());
    }

    @Test
    public void testParamsWithEmptyInput() throws InvalidCommandException {
        List<String> params = application.extractParams("C 20 4");
        assertEquals(2, params.size());
    }

    @Test
    public void testProcessWithCanvasCommand() throws InvalidCommandException {
        List<String> params = application.extractParams("C 20 4");
        application.process("C", params);
    }

    @Test
    public void testProcessWithLine1Command() throws InvalidCommandException {
        List<String> params = application.extractParams("L 1 2 6 2");
        application.charArray = new char[6][20];
        application.process("L", params);
    }

    @Test
    public void testProcessWithLine2Command() throws InvalidCommandException {
        List<String> params = application.extractParams("L 6 3 6 4");
        application.charArray = new char[6][20];
        application.process("L", params);
    }

    @Test
    public void testProcessWithRectangleCommand() throws InvalidCommandException {
        List<String> params = application.extractParams("R 14 1 18 3");
        application.charArray = new char[6][20];
        application.fillArray = new char[6][20];
        application.process("R", params);
    }

    @Test
    public void testProcessWithFillCommand() throws InvalidCommandException {
        List<String> params = application.extractParams("B 10 3 c");
        application.charArray = new char[6][20];
        application.fillArray = new char[6][20];
        application.process("B", params);
    }
}
