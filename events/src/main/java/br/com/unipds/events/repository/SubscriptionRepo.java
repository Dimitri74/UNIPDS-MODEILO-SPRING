package br.com.unipds.events.repository;


import br.com.unipds.events.model.Session;
import br.com.unipds.events.model.Subscription;
import br.com.unipds.events.model.SubscriptionID;
import br.com.unipds.events.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;


public interface SubscriptionRepo extends ListCrudRepository<Subscription, SubscriptionID>{
    public List<Subscription> findByIdUser(User user);
    public List<Subscription> findByIdSession(Session session);
}