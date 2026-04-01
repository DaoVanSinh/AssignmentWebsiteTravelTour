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

    public User register(String fullName,String email,String phone,String password){

    if(userRepository.existsByEmail(email)){
        throw new RuntimeException("Email đã tồn tại");
    }

    if(userRepository.existsByPhone(phone)){
        throw new RuntimeException("Số điện thoại đã tồn tại");
    }

    User user = new User();

    user.setFullName(fullName);
    user.setEmail(email);
    user.setPhone(phone);
    user.setPassword(password);
    user.setRole("USER");

    return userRepository.save(user);
}

    public User login(String email,String password){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Mật khẩu không trùng khớp");
        }

        return user;
    }

    public User forgotPassword(String email,String newPassword){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Không tìm thấy email"));

        if(newPassword.length() < 6){
            throw new RuntimeException("Mật khẩu mới phải từ 6 ký tự trở lên!");
        }

        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    public boolean checkEmail(String email){
        return userRepository.existsByEmail(email);
    }
}