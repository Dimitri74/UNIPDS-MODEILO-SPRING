package br.com.unipds.events.repository;


import org.springframework.data.repository.ListCrudRepository;
import br.com.unipds.events.model.Session;


public interface SessionRepo extends ListCrudRepository<Session, Integer>{

}
