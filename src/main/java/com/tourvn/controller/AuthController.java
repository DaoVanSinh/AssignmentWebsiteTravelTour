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

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> request){
        return userService.register(
        request.get("name"),
        request.get("email"),
        request.get("phone"),
        request.get("password"));
    }

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> request){
        return userService.login(request.get("email"), request.get("password"));
    }
}