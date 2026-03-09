package br.com.unipds.events.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

import br.com.unipds.events.model.Session;
import br.com.unipds.events.service.ISessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Sessions", description = "Endpoints para gerenciamento de sessões")
public class SessionController {

    private final ISessionService service;

    public SessionController(ISessionService service) {
        this.service = service;
    }

    @PostMapping("/sessions")
    public ResponseEntity<Session> addSession(@RequestBody Session session){
        return ResponseEntity.status(201).body(service.addSession(session));
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<Session>> getAllSessions(){
        return ResponseEntity.ok(service.getAllSessions());
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<Session> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getSessionById(id));
    }


}