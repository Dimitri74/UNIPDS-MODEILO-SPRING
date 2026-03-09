package br.com.unipds.events.service;

import br.com.unipds.events.model.Session;
import java.util.List;



public interface ISessionService {
    public Session addSession(Session session);
    public Session getSessionById(Integer id);
    public List<Session> getAllSessions();
}