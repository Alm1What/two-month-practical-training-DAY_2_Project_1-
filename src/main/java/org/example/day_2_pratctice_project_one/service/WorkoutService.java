package org.example.day_2_pratctice_project_one.service;

import jakarta.transaction.Transactional;
import org.example.day_2_pratctice_project_one.entity.Client;
import org.example.day_2_pratctice_project_one.entity.Workout;
import org.example.day_2_pratctice_project_one.repository.ClientRepository;
import org.example.day_2_pratctice_project_one.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkoutService {

    private WorkoutRepository workoutRepository;
    private ClientRepository clientRepository;

    public WorkoutService(WorkoutRepository workoutRepository, ClientRepository clientRepository) {
        this.workoutRepository = workoutRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Workout createWorkout(Workout workout, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        workout.setDate(LocalDateTime.now());
        workout.setClient(client);
        return workoutRepository.save(workout);
    }



    public Workout findWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found with id: " + workoutId));
    }

    public List<Workout> findWorkoutsByClientId(Long clientId) {
        clientRepository.findById(clientId).orElseThrow(
                () -> new RuntimeException("Client not found")
        );
        return workoutRepository.findWorkoutsByClientId(clientId);
    }

    public Workout updateWorkout(Long workoutId, Workout workout) {
        Workout oldWorkout = workoutRepository.findWorkoutById(workoutId);
        oldWorkout.setExercises(workout.getExercises());
        return workoutRepository.save(oldWorkout);
    }




}
