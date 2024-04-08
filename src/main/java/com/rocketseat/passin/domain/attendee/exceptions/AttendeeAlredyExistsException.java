package com.rocketseat.passin.domain.attendee.exceptions;

public class AttendeeAlredyExistsException extends RuntimeException{
    public AttendeeAlredyExistsException(String message) {
        super(message);
    }
}
