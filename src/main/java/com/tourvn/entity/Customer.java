package com.tourvn.entity;
import jakarta.persistence.*;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerId;
    private String name;
    private String email;
    private String password;

public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
}
}