package org.example.day_2_pratctice_project_one.repository;

import org.example.day_2_pratctice_project_one.entity.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @EntityGraph(attributePaths = {"trainer"})  // Завантажує trainer одразу
    Optional<Client> findWithTrainerById(Long id);
}
