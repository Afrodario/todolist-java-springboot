package it.softwareInside.NoteAppLezione22.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.softwareInside.NoteAppLezione22.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

}
