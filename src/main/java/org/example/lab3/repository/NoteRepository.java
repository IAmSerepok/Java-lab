package org.example.lab3.repository;

import org.example.lab3.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

}
