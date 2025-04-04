package org.example.day_2_pratctice_project_one.repository;

import org.example.day_2_pratctice_project_one.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
