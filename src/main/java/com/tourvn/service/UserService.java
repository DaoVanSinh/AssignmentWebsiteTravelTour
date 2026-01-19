package com.tourvn.service;

import com.tourvn.entity.User;

public interface UserService {

    User register(String username, String password, String email);

    User login(String username, String password);
}
