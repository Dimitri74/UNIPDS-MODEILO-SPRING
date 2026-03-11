package com.unipds.account.repository;


import com.unipds.account.model.Transaction;
import org.springframework.data.repository.ListCrudRepository;


public interface TransactionRepo extends ListCrudRepository<Transaction, Integer>{

}