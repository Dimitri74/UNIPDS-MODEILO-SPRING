package com.unipds.account.service;

import java.time.LocalDateTime;

import com.unipds.account.dto.TransferDTO;
import com.unipds.account.exception.InvalidAccountException;
import com.unipds.account.model.Account;
import com.unipds.account.model.Transaction;
import com.unipds.account.repository.AccountRepo;
import com.unipds.account.repository.TransactionRepo;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TransferService implements ITransferService {

    private AccountRepo accountRepo;
    private TransactionRepo transactionRepo;

    public TransferService(AccountRepo accountRepo, TransactionRepo transactionRepo) {
        super();
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }



    @Override
    @Transactional
    public Transaction transferValues(TransferDTO transferDto) {
        // TODO Auto-generated method stub
        Account src = accountRepo.findById(transferDto.debitAccountNumber())
                .orElseThrow(() -> new InvalidAccountException("Account #"+transferDto.debitAccountNumber()+" does not exists"));
        Account dst = accountRepo.findById(transferDto.creditAccountNumber())
                .orElseThrow(() -> new InvalidAccountException("Account #"+transferDto.creditAccountNumber()+ " does not exists"));


        dst.setBalance(dst.getBalance() + transferDto.amount());
        accountRepo.save(dst);
        System.out.println("Account "+dst.getNumber()+ " New Balance $ "+dst.getBalance());
        src.setBalance(src.getBalance() - transferDto.amount());
        accountRepo.save(src);
        System.out.println("Account "+src.getNumber()+ " New Balance $ "+src.getBalance());

        Transaction transaction = new Transaction();
        transaction.setDebitAccount(src);
        transaction.setCreditAccount(dst);
        transaction.setAmount(transferDto.amount());
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepo.save(transaction);
    }

}