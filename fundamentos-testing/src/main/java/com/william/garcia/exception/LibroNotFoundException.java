package com.william.garcia.exception;

public class LibroNotFoundException extends RuntimeException{
    public LibroNotFoundException(String message) {
        super(message);
    }
}
