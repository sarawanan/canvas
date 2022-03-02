package com.cs.canvas.exception;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }

    public InvalidCommandException(String message, Throwable th) {
        super(message, th);
    }
}
