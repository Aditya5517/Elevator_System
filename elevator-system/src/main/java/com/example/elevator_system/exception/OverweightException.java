package com.example.elevator_system.exception;
public class OverweightException extends RuntimeException {
    public OverweightException(String message) {
        super(message);
    }
}