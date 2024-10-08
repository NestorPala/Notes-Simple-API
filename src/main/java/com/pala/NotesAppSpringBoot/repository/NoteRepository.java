package com.pala.NotesAppSpringBoot.repository;

import com.pala.NotesAppSpringBoot.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findAll();
    List<Note> findNotesByIsArchived(Boolean isArchived);

    List<Note> findAllByOrderByTitleAsc();
    List<Note> findAllByOrderByTitleDesc();

    List<Note> findAllByOrderByContentAsc();
    List<Note> findAllByOrderByContentDesc();

}
