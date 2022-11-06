package com.codegym.util.exeption;

public class MyException extends Exception{
    String message;
    public MyException(String str) {
        message = str;
    }
    public String toString() {
        return ("Custom Exception Occurred : " + message);
    }
}
