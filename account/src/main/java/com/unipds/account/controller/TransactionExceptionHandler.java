package com.unipds.account.controller;

import com.unipds.account.dto.ErrorDTO;
import com.unipds.account.exception.InvalidAccountException;
import com.unipds.account.exception.InvalidBalanceAccountException;
import com.unipds.account.exception.InvalidTransferException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class TransactionExceptionHandler {

    @ExceptionHandler(InvalidAccountException.class)
    public ResponseEntity<ErrorDTO> handleInvalidAccount(InvalidAccountException ex){
        return ResponseEntity.status(404).body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidBalanceAccountException.class)
    public ResponseEntity<ErrorDTO> handleInvalidBalance(InvalidBalanceAccountException ex){
        return ResponseEntity.status(400).body(new ErrorDTO(ex.getMessage()));
    }

    @ExceptionHandler(InvalidTransferException.class)
    public ResponseEntity<ErrorDTO> handleInvalidTransfer(InvalidTransferException ex){
        return ResponseEntity.status(400).body(new ErrorDTO(ex.getMessage()));
    }


}