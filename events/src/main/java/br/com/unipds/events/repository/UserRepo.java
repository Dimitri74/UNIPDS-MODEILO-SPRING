package br.com.unipds.events.repository;

import java.util.Optional;

import br.com.unipds.events.model.User;
import org.springframework.data.repository.ListCrudRepository;


public interface UserRepo extends ListCrudRepository<User, Integer> {

    public Optional<User> findByEmail(String email);
}
