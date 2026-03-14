package com.unipds.authapi.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unipds.authapi.model.User;
import com.unipds.authapi.repository.UserRepo;
import com.unipds.authapi.security.MyToken;
import com.unipds.authapi.security.TokenUtil;

@Service
public class UserService implements IUserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public MyToken userLogin(User user) {
        User found = userRepo.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(user.getPassword(), found.getPassword())) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return TokenUtil.encode(found);
    }
}

