package com.example.guzhengtuner.exception;

public class QuitExceptionHandler extends RuntimeException{
    public QuitExceptionHandler(String message) {
        super(message);
    }
}
