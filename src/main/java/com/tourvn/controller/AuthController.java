 package com.tourvn.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.tourvn.entity.User;
import com.tourvn.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    
    public AuthController(UserService userService){
        this.userService = userService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(
        user.getFullName(),
        user.getEmail(),
        user.getPhone(),
        user.getPassword());
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> request){
        return userService.login(request.get("email"), request.get("password"));
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/forgot-password")
    public User forgotPasssword(@RequestBody Map<String, String> request){
        return userService.forgotPassword(request.get("email"),request.get("newPassword"));
    }
}