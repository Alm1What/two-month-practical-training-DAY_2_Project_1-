package org.example.day_2_pratctice_project_one.service;

import jakarta.transaction.Transactional;
import org.example.day_2_pratctice_project_one.entity.Client;
import org.example.day_2_pratctice_project_one.entity.Trainer;
import org.example.day_2_pratctice_project_one.repository.ClientRepository;
import org.example.day_2_pratctice_project_one.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;
    private ClientRepository clientRepository;

    public TrainerService(TrainerRepository trainerRepository,
                          ClientRepository clientRepository) {
        this.trainerRepository = trainerRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Trainer addClientToTrainer(Long trainerId, Client client) {
        if (trainerId == null || client == null) {
            throw new IllegalArgumentException("Trainer id and client must not be null");
        }

        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));

        client.setTrainer(trainer);
        trainer.getClients().add(client);

        clientRepository.save(client);

        return trainerRepository.save(trainer);
    }


    public List<Client> getAllClients(Long trainerId) {
        if (!trainerRepository.existsById(trainerId)) {
            throw new IllegalArgumentException("Trainer id " + trainerId + " does not exist");
        }

        Trainer trainer = trainerRepository.findById(trainerId).orElseThrow();
        return trainer.getClients();
    }

    public Trainer createTrainer(Trainer trainer) {
        if (trainer == null) {
            throw new IllegalArgumentException("Trainer must not be null");
        }
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long trainerId, Trainer trainer) {
        Trainer oldTrainer = trainerRepository.findById(trainerId).orElseThrow();
        oldTrainer.setName(trainer.getName());
        oldTrainer.setSpecialization(trainer.getSpecialization());
        return trainerRepository.save(oldTrainer);
    }

    public Trainer deleteTrainerById(Long trainerId) {
        Trainer trainer = trainerRepository.findById(trainerId).orElseThrow();
        trainerRepository.delete(trainer);
        return trainer;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Long trainerId) {
        return trainerRepository.findById(trainerId).orElseThrow();
    }
}
