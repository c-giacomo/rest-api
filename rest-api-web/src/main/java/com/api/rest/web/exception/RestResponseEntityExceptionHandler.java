package com.api.rest.web.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;


@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Validation Failed");
        pd.setDetail("One or more fields are invalid.");
        pd.setType(URI.create("https://example.com/problems/validation-error"));
        pd.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .headers(headers)
                .body(pd);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleItemNotFoundException(EntityNotFoundException ex, WebRequest request) {
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle(ex.getMessage());
        pd.setDetail(String.join(",", ex.getMessage()));
        pd.setType(URI.create("https://example.com/problems/validation-error"));
        pd.setInstance(URI.create(request.getDescription(false).replace("uri=", "")));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(pd);
    }
}
