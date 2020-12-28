package com.example.exceptions;

public class FirstAidKitException extends RuntimeException { //+1
    public FirstAidKitException(String message) {
        super(message);
    }
}