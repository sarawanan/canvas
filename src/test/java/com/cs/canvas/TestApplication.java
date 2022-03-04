package com.cs.canvas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestApplication {
    private Application application;

    @BeforeAll
    public void setUp() {
        application = new Application();
        application.width = 20;
        application.height = 4;
        application.charArray = new char[6][20];
        application.fillArray = new char[6][20];
    }

    @Test()
    public void testIfInputIsBlank() {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> Utils.extractCommand("")
        );
        assertEquals("Please enter valid command", thrown.getMessage());
    }

    @Test()
    public void testInvalidCommand() {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> Utils.extractCommand("X")
        );
        assertEquals("Only the following ['B','C','L','R','Q'] commands are valid!", thrown.getMessage());
    }

    @Test()
    public void testValidCommand() throws InvalidCommandException {
        String command = Utils.extractCommand("C 20 4");
        assertEquals("C", command);
    }

    @Test
    public void testValidParams() {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> Utils.extractParams("")
        );
        assertEquals("Please enter valid command", thrown.getMessage());
    }

    @Test
    public void testParamsWithEmptyInput() throws InvalidCommandException {
        List<String> params = Utils.extractParams("C 20 4");
        assertEquals(2, params.size());
    }

    @Test
    public void testProcessWithCanvasCommand() throws InvalidCommandException {
        application.process("C 20 4");
    }

    @Test
    public void testProcessWithFillCommandCanvasNotInitialized() {
        application.canvasInitiated = false;
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> application.process("B 10 3 c")
        );
        assertEquals("First initialize the canvas", thrown.getMessage());
    }

    @Test
    public void testProcessWithFillCommand() throws InvalidCommandException {
        application.canvasInitiated = true;
        application.process("B 10 3 c");
    }

    @Test
    public void testProcessWithLineCommandCanvasNotInitialized() {
        application.canvasInitiated = false;
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> application.process("L 1 2 6 2")
        );
        assertEquals("First initialize the canvas", thrown.getMessage());
    }

    @Test
    public void testProcessWithLineCommand() throws InvalidCommandException {
        application.canvasInitiated = true;
        application.process("L 1 2 6 2");
    }

    @Test
    public void testProcessWithRectangleCommandCanvasNotInitialized() {
        application.canvasInitiated = false;
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> application.process("R 14 1 18 3")
        );
        assertEquals("First initialize the canvas", thrown.getMessage());
    }

    @Test
    public void testProcessWithRectangleCommand() throws InvalidCommandException {
        application.canvasInitiated = true;
        application.process("R 14 1 18 3");
    }
}
