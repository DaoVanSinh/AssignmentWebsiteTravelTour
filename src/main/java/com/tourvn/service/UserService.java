package com.tourvn.service;

import com.tourvn.repository.UserRepository;

import org.springframework.stereotype.Service;

import com.tourvn.entity.User;

@Service
public class UserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(String name,String email,String phone,String password){
        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email đã tồn tại");
        }

        if(userRepository.existsByPhone(phone)){
            throw new RuntimeException("Số điện thoại đã tồn tại");   
        }

        if(password.length() < 6){
            throw new RuntimeException("Mật khẩu phải đủ từ 6 ký tự trở lên");
        }

        User user = new User();
        user.setname(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRole("USER");

        return userRepository.save(user);
    }

    public User login(String email,String password){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email không tồi tại"));

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Mật khẩu không trùng khớp");
        }

        return user;
    }
}