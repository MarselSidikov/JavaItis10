package ru.itis.exceptions;

public class EmptyCredentialsException extends RuntimeException {
    public EmptyCredentialsException(String message) {
        super(message);
    }
}
