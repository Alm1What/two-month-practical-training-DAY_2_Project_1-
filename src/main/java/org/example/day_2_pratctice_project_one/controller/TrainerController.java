package org.example.day_2_pratctice_project_one.controller;

import org.example.day_2_pratctice_project_one.entity.Client;
import org.example.day_2_pratctice_project_one.entity.Trainer;
import org.example.day_2_pratctice_project_one.service.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @PostMapping()
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.createTrainer(trainer));
    }

    @GetMapping("/all-trainer")
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        return ResponseEntity.ok(trainerService.getAllTrainers());
    }

    @PutMapping("/{trainerId}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long trainerId, @RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainer(trainerId, trainer));
    }

    @GetMapping("/{trainerId}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable Long trainerId) {
        return ResponseEntity.ok(trainerService.getTrainerById(trainerId));
    }

    @DeleteMapping("/{trainerId}")
    public ResponseEntity<Trainer> deleteTrainer(@PathVariable Long trainerId) {
        return ResponseEntity.ok(trainerService.deleteTrainerById(trainerId));
    }

    @GetMapping("/trainers/{id}/trainer")
    public ResponseEntity<List<Client>> getClientsByTrainer(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.getAllClients(id));
    }

    @PostMapping("/add-client-trainer")
    public ResponseEntity<Trainer> addClientTrainer(
            @RequestParam Long trainerId,
            @RequestBody Client client
    ) {
        return ResponseEntity.ok(trainerService.addClientToTrainer(trainerId, client));
    }

}
