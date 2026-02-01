package com.tourvn.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = true) 
    
    private String description;

    private Double price;

    private String imageUrl;

    private String title;
}