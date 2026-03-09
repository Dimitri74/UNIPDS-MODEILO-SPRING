package br.com.unipds.events.service;


import java.util.List;

import br.com.unipds.events.exception.NotFoundException;
import br.com.unipds.events.model.User;
import br.com.unipds.events.repository.UserRepo;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements IUserService{

    private UserRepo repo;


    public UserServiceImpl(UserRepo repo) {
        super();
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
        // TODO Auto-generated method stub
        return repo.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElseThrow(() -> new NotFoundException("User "+id+" not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        // TODO Auto-generated method stub
        return repo.findByEmail(email).orElseThrow(()-> new NotFoundException("Email "+email+" not registered"));
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

}