package com.SPRINBOOT.springboot.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.SPRINBOOT.springboot.entity.ErrorMessage;

import java.time.LocalDateTime;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departNotFoundException(DepartmentNotFoundException exception,WebRequest request){

        ErrorMessage errorMessage=new ErrorMessage();

        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimestamp(LocalDateTime.now());
        errorMessage.setErrorCode("DEPARTMENT_NOT_FOUND");
        errorMessage.setPath(request.getDescription(false).substring(4)); // Extracting path from request description

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
