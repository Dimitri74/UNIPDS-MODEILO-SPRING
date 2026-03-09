package br.com.unipds.events.service;


import br.com.unipds.events.exception.NotFoundException;
import br.com.unipds.events.model.Conference;
import br.com.unipds.events.repository.ConferenceRepo;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ConferenceServiceImpl implements IConferenceService{

    private ConferenceRepo repo;


    public ConferenceServiceImpl(ConferenceRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public Conference addConference(Conference conference) {
        // TODO Auto-generated method stub
        return repo.save(conference);
    }

    @Override
    public Conference getConferenceById(Integer id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Conference not found: "+ id));
    }

    @Override
    public List<Conference> getAllConferences() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

}
