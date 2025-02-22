package io.github.gabrielhenriquehe.transacao_api.infrastructure;

import io.github.gabrielhenriquehe.transacao_api.infrastructure.exceptions.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalRequestHandler {
    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<Void> handleUnprocessableEntityException(UnprocessableEntityException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Void> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();
    }
}
