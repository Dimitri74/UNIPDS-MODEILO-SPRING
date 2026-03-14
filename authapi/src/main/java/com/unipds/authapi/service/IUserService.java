package com.unipds.authapi.service;

import com.unipds.authapi.model.User;
import com.unipds.authapi.security.MyToken;

public interface IUserService {

    User addUser(User user);

    MyToken userLogin(User user);
}

