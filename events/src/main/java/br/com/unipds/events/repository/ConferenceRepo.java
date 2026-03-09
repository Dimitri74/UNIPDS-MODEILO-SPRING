package br.com.unipds.events.repository;

import br.com.unipds.events.model.Conference;
import org.springframework.data.repository.ListCrudRepository;



public interface ConferenceRepo extends ListCrudRepository<Conference, Integer>{

}