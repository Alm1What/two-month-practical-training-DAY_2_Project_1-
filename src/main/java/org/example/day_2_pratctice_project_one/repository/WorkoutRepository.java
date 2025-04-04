package org.example.day_2_pratctice_project_one.repository;

import org.example.day_2_pratctice_project_one.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    List<Workout> findWorkoutsByClientId(Long clientId);

    Workout findWorkoutById(Long workoutId);
}
