package br.com.unipds.events.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import br.com.unipds.events.model.Session;
import br.com.unipds.events.model.Subscription;
import br.com.unipds.events.model.User;
import br.com.unipds.events.service.ISubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Tag(name = "Subscriptions", description = "Endpoints para gerenciamento de inscrições")
public class SubscriptionController {

    private ISubscriptionService service;

    public SubscriptionController(ISubscriptionService service) {
        this.service = service;
    }


    @PostMapping("/subscriptions")
    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription){
        System.out.println("DEBUG = "+subscription);
        return ResponseEntity.status(201).body(service.addSubscription(subscription));
    }

    @GetMapping("/subscriptions/user/{id}")
    public ResponseEntity<List<Subscription>> getByUser(@PathVariable Integer id){
        User user = new User();
        user.setUserId(id);
        return ResponseEntity.ok(service.getAllByUser(user));
    }

    @GetMapping("/subscriptions/session/{id}")
    public ResponseEntity<List<Subscription>> getBySession(@PathVariable Integer id){
        Session session = new Session();
        session.setIdSession(id);
        return ResponseEntity.ok(service.getAllBySession(session));
    }

}