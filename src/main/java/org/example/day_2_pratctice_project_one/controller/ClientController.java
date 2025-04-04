package org.example.day_2_pratctice_project_one.controller;

import org.example.day_2_pratctice_project_one.entity.Client;
import org.example.day_2_pratctice_project_one.repository.ClientRepository;
import org.example.day_2_pratctice_project_one.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.updateClient(client, clientId));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.deleteClientById(clientId));
    }

    @GetMapping("/all-clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }
}
