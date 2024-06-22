package org.example.lab3.controller;

import org.example.lab3.annotation.ControllerExceptionHandler;
import org.example.lab3.dto.*;
import org.example.lab3.model.*;
import org.example.lab3.service.*;

import org.modelmapper.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@ControllerExceptionHandler
public class ClientController {

    private final ClientService clientService;

    private final ModelMapper modelMapper;

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getClientById(@PathVariable Long id) {

        var client = clientService.getClientById(id);
        var responseDto = modelMapper.map(client, ClientResponseByIdDto.class);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientCreateResponseDto createClient(@RequestBody ClientCreateDto creationDto){
        var newClient = modelMapper.map(creationDto, Client.class);
        clientService.createClient(newClient);

        var clientId = newClient.getId();

        return new ClientCreateResponseDto().setId(clientId);
    }

    @PutMapping("user/{id}/username")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateClientUsername(
            @PathVariable Long id,
            @RequestBody ClientUpdateUsernameDto updateDto
    ) {

        var client = clientService.getClientById(id);

        var newUsername = updateDto.getUsername();
        var password = updateDto.getPassword();

        clientService.updateClientUsername(client, newUsername, password);

        return ResponseEntity.ok(new ClientUpdateResponseDto().setId(id).setUsername(newUsername));
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteClient(
            @PathVariable Long id,
            @RequestBody ClientDeleteDto deleteDto
    ) {
        clientService.deleteClient(id, deleteDto.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body("User with id = " + id.toString() + " deleted");
    }

}
