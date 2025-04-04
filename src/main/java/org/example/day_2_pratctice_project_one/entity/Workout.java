package org.example.day_2_pratctice_project_one.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String exercises;

}
