package com.rocketseat.passin.domain.checkin.exceptions;

public class CheckInAlredyExistsException extends RuntimeException{
    public CheckInAlredyExistsException(String message) {
        super(message);
    }
}
