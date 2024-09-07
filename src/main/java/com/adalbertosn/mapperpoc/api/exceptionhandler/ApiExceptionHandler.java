package com.adalbertosn.mapperpoc.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Problem> treatEntityNotFoundException(
            EntityNotFoundException e) {
        Problem problema = Problem.builder()
                .dataHora(LocalDateTime.now())
                .mensagem(e.getMessage())
                .code(e.getCode()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(problema);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Problem> treatBusinessException(BusinessException e) {
        Problem problema = Problem.builder()
                .dataHora(LocalDateTime.now())
                .mensagem(e.getMessage())
                .code(e.getCode()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(problema);
    }

    /*
    @ExceptionHandler(MechanismNotFoundException.class)
    public ResponseEntity<Problem> treatMechanismNotFoundException(BusinessException e) {
        Problem problema = Problem.builder()
                .dataHora(LocalDateTime.now())
                .mensagem(e.getMessage())
                .code(e.getCode()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(problema);
    }
     */

}
