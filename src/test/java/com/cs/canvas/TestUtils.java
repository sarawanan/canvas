package com.cs.canvas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestUtils {
    @Test
    public void testExtractCommandIsBlank() {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> Utils.extractCommand("")
        );
        assertEquals("Please enter valid command", thrown.getMessage());
    }

    @Test
    public void testExtractInValidCommand() throws InvalidCommandException {
        InvalidCommandException thrown = assertThrows(
                InvalidCommandException.class,
                () -> Utils.extractCommand("X 20 4")
        );
        assertEquals("Only the following ['B','C','L','R','Q'] commands are valid!", thrown.getMessage());
    }

    @Test
    public void testExtractValidCommand() throws InvalidCommandException {
        assertEquals("C", Utils.extractCommand("C 20 4"));
    }
}
