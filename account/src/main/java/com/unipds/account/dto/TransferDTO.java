package com.unipds.account.dto;


public record TransferDTO(Integer debitAccountNumber, Integer creditAccountNumber, Double amount) {

}