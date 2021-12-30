package ru.matveykenya.springrestauthorizationservice.exception;

public class InvalidPassword extends RuntimeException {
    public InvalidPassword(String msg) {
        super(msg);
    }
}