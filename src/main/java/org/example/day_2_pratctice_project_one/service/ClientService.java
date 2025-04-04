package org.example.day_2_pratctice_project_one.service;

import jakarta.transaction.Transactional;
import org.example.day_2_pratctice_project_one.entity.Client;
import org.example.day_2_pratctice_project_one.repository.ClientRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client must not be null");
        }
        return clientRepository.save(client);
    }

    @Transactional
    public Client getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Примусово завантажуємо тренера
        Hibernate.initialize(client.getTrainer());

        return client;
    }

    public Client updateClient(Client client, Long clientId) {
        Client oldClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(oldClient.getName());
        client.setAge(oldClient.getAge());
        return clientRepository.save(client);
    }

    public Client deleteClientById(Long clientId) {
        Client oldClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        clientRepository.delete(oldClient);
        return oldClient;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

}
