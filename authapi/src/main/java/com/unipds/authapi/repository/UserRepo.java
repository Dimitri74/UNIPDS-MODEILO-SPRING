package com.unipds.authapi.repository;


import java.util.Optional;

import com.unipds.authapi.model.User;
import org.springframework.data.repository.ListCrudRepository;


public interface UserRepo extends ListCrudRepository<User, Integer>{

    public Optional<User> findByUsername(String username);
}