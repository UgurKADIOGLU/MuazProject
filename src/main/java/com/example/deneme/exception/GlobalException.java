package com.example.deneme.exception;

import com.example.deneme.entities.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler
    protected ResponseEntity<ErrorMessage> handleValidException(MethodArgumentNotValidException ex,WebRequest request){
        Map<String,String> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError->{errors.put(fieldError
                .getField(),fieldError.getDefaultMessage());
        });
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(errors.toString())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    protected ResponseEntity<ErrorMessage> handleRunTimeException(RuntimeException ex, WebRequest request){
        ErrorMessage error = ErrorMessage.builder()
                .timestamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(ex.getMessage())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    protected ResponseEntity<ErrorMessage> handleAllException(Exception ex, WebRequest request){
        ErrorMessage error = ErrorMessage.builder()
                .timestamp(new Date())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(ex.getMessage())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
