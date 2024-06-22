package org.example.lab3.service;

import lombok.RequiredArgsConstructor;
import org.example.lab3.exception.NotFoundException;
import org.example.lab3.model.Note;
import org.example.lab3.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public void createNote(Note note) {
        noteRepository.save(note);
    }

    public Note getNoteById(Long id){
        return noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        "Заметка с указанным id не найдена"
                ));
    }

    public void updateNoteTitle(Note note, String newTitle) {
        var updateNote = getNoteById(note.getId());
        updateNote.setTitle(newTitle);

        noteRepository.save(updateNote);
    }

    public void deleteNote(Long id) {
        noteRepository.delete(getNoteById(id));
    }
}
