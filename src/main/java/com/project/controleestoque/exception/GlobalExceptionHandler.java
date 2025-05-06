package com.project.controleestoque.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<Map<String, String>> handleUsernameDuplicado(RegistroDuplicadoException e) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}
