package org.example.day_2_pratctice_project_one.service;

import org.example.day_2_pratctice_project_one.entity.Client;
import org.example.day_2_pratctice_project_one.entity.Workout;
import org.example.day_2_pratctice_project_one.repository.ClientRepository;
import org.example.day_2_pratctice_project_one.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private WorkoutRepository workoutRepository;
    private ClientRepository clientRepository;

    public WorkoutService(WorkoutRepository workoutRepository, ClientRepository clientRepository) {
        this.workoutRepository = workoutRepository;
        this.clientRepository = clientRepository;
    }

    public Workout createWorkout(Workout workout, Long clientId) {
        clientRepository.findById(clientId).ifPresent(workout::setClient);
        return workoutRepository.save(workout);
    }

    public Workout addWorkoutToClient(Workout workout, Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        workout.setClient(client);
        client.getWorkouts().add(workout);
        return workoutRepository.save(workout);
    }

    public Workout findWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId).orElseThrow();
    }




}
