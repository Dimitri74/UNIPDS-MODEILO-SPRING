package br.com.unipds.events.service;



import br.com.unipds.events.model.Session;
import br.com.unipds.events.model.Subscription;
import br.com.unipds.events.model.User;

import java.util.List;


public interface ISubscriptionService {
    public Subscription addSubscription(Subscription subscription);
    public List<Subscription> getAllByUser(User user);
    public List<Subscription> getAllBySession(Session session);
}