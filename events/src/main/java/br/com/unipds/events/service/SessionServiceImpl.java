package br.com.unipds.events.service;


import java.util.List;

import br.com.unipds.events.exception.NotFoundException;
import br.com.unipds.events.model.Session;
import br.com.unipds.events.repository.SessionRepo;
import org.springframework.stereotype.Service;


@Service
public class SessionServiceImpl implements ISessionService{

    private SessionRepo repo;


    public SessionServiceImpl(SessionRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Session addSession(Session session) {
        // TODO Auto-generated method stub
        return repo.save(session);
    }


    @Override
    public Session getSessionById(Integer id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElseThrow(()-> new NotFoundException("Session "+id+" not found"));
    }

    @Override
    public List<Session> getAllSessions() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

}
