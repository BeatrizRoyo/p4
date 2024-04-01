package edu.comillas.icai.gitt.pat.spring.mvc;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejar una excepción específica
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<?> recursoNoEncontradoManejador(RecursoNoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Manejar cualquier otra excepción que no se haya capturado específicamente
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex) {
        return new ResponseEntity<>("Ocurrió un error en el servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
