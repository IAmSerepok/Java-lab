package org.example.lab3.controller;

import org.example.lab3.annotation.ControllerExceptionHandler;
import org.example.lab3.dto.*;
import org.example.lab3.model.*;
import org.example.lab3.service.*;

import lombok.*;
import org.modelmapper.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@ControllerExceptionHandler
public class NoteController {

    private final NoteService noteService;
    private final ClientService clientService;

    private final ModelMapper modelMapper;

    @GetMapping("/note/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getNoteById(@PathVariable Long id) {

        var note = noteService.getNoteById(id);
        var noteDto = modelMapper.map(note, NoteResponseByIdDto.class);
        noteDto.setClient(note.getClient());

        return ResponseEntity.ok(noteDto);
    }

    @PostMapping("/note")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNote(
            @RequestBody NoteCreateDto creationDto
    ) {
        System.out.println(creationDto.getClient());

        var newNote = modelMapper.map(creationDto, Note.class);
        noteService.createNote(newNote);

        var title = creationDto.getTitle();

        var client = clientService.getClientById(creationDto.getClient().getId());
        var noteId = newNote.getId();

        return ResponseEntity.ok(new NoteCreateResponseDto().setId(noteId).setTitle(title).setClient(client));
    }

    @PutMapping("note/{id}/title")
    public ResponseEntity<?> updateNoteTitle(
            @PathVariable Long id,
            @RequestBody NoteUpdateTitleDto noteUpdateTitleDto
    ){
        var note = noteService.getNoteById(id);
        var newTitle = noteUpdateTitleDto.getTitle();

        noteService.updateNoteTitle(note, newTitle);

        var noteDto = modelMapper.map(note, NoteResponseByIdDto.class);

        return ResponseEntity.ok(noteDto);
    }

    @DeleteMapping("note/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {

        noteService.deleteNote(id);
        return ResponseEntity.status(HttpStatus.OK).body("Note with id = " + id.toString() + " was deleted.");
    }

}
