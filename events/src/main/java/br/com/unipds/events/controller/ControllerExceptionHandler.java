package br.com.unipds.events.controller;



import br.com.unipds.events.dto.ErrorDTO;
import br.com.unipds.events.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException ex){
        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }

}