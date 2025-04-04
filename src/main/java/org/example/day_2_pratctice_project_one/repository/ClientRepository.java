package org.example.day_2_pratctice_project_one.repository;

import org.example.day_2_pratctice_project_one.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
