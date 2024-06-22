package org.example.lab3.service;

import lombok.RequiredArgsConstructor;
import org.example.lab3.exception.NotFoundException;
import org.example.lab3.exception.ValidatorException;
import org.example.lab3.model.Client;
import org.example.lab3.repository.ClientRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Пользователь с указанным id не найден"
                ));
    }

    public void updateClientUsername(Client client, String newUsername, String password) {
        var updateClient = getClientById(client.getId());
        if (updateClient.getPassword().equals(password)) {
            updateClient.setUsername(newUsername);

            clientRepository.save(updateClient);
        }
        else{
            throw new ValidatorException("Не верный пароль");
        }
    }

    public void deleteClient(Long id, String password) {

        var deleteClient = getClientById(id);

        if (password.equals(deleteClient.getPassword())) {
            clientRepository.delete(deleteClient);
        } else {
            throw new ValidatorException("Не верный пароль");
        }
    }
}
