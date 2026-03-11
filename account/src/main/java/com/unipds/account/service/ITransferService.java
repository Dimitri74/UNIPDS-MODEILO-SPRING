package com.unipds.account.service;


import com.unipds.account.dto.TransferDTO;
import com.unipds.account.model.Transaction;

public interface ITransferService {
    public Transaction transferValues(TransferDTO transferDto);

}