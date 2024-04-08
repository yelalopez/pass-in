package com.rocketseat.passin.config;

import com.rocketseat.passin.domain.attendee.exceptions.AttendeeAlredyExistsException;
import com.rocketseat.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import com.rocketseat.passin.domain.checkin.exceptions.CheckInAlredyExistsException;
import com.rocketseat.passin.domain.event.exceptions.EventFullException;
import com.rocketseat.passin.domain.event.exceptions.EventNotFoundException;
import com.rocketseat.passin.dto.exceptions.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {


    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorResponseDTO> handleEventFull(EventFullException ex){
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlredyExistsException.class)
    public ResponseEntity handleAttendeeAlredyExists(AttendeeAlredyExistsException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlredyExistsException.class)
    public ResponseEntity handleCheckInAlredyExists(CheckInAlredyExistsException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
