package com.tourvn.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "tours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(name = "start_date")
    private LocalDate startDate;

    private String imageUrl;

    private String title;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "max_people")
    private Integer maxPeople;

}