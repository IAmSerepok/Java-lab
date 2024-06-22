package org.example.lab3.repository;

import org.example.lab3.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ClientRepository extends CrudRepository<Client, Long> {
//    Client findByName(String name);
//    List<Client> findAllByUsername(String username);
}
