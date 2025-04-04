package org.example.day_2_pratctice_project_one.controller;

import org.example.day_2_pratctice_project_one.entity.Workout;
import org.example.day_2_pratctice_project_one.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping("/{clientId}")
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout, @PathVariable Long clientId) {
        return ResponseEntity.ok(workoutService.createWorkout(workout, clientId));
    }

    @GetMapping()
    public ResponseEntity<Workout> getWorkoutById(@RequestParam Long workoutId) {
        return ResponseEntity.ok(workoutService.findWorkoutById(workoutId));
    }

    @GetMapping("/client-workouts/{clientId}")
    public ResponseEntity<List<Workout>> getWorkoutByClientId(@PathVariable Long clientId) {
        return ResponseEntity.ok(workoutService.findWorkoutsByClientId(clientId));
    }

    @PutMapping("/{workoutId}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long workoutId, @RequestBody Workout workout) {
        return ResponseEntity.ok(workoutService.updateWorkout(workoutId, workout));
    }
}
