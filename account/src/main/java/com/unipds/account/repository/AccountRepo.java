package com.unipds.account.repository;


import com.unipds.account.model.Account;
import org.springframework.data.repository.ListCrudRepository;


public interface AccountRepo extends ListCrudRepository<Account, Integer>{


}