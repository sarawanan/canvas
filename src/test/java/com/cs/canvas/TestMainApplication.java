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
        List<String> params = application.extractParams("C 20 4");
        assertEquals(2, params.size());
    }
}
