package com.training.faculty.web.exceptionhandler;

import com.training.faculty.service.exception.NotFoundException;
import com.training.faculty.web.dto.ExceptionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @Autowired
    private ModelMapper mapper;

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ExceptionDTO> handleNotFoundException(
            NotFoundException ex) {
        return new ResponseEntity<>(mapper.map(ex, ExceptionDTO.class),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionDTO> handleException(
            Exception ex) {
        return new ResponseEntity<>(mapper.map(ex, ExceptionDTO.class),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
