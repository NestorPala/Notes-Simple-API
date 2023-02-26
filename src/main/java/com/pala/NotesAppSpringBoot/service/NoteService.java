package com.pala.NotesAppSpringBoot.service;

import com.pala.NotesAppSpringBoot.DTO.NoteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    public List<NoteDTO> getAll() {
        return List.of(new NoteDTO(1L, "Lorem Ipsum", "ABC", false));
    }

    public NoteDTO create() {
        return new NoteDTO();
    }

    public NoteDTO edit(Long id) {
        return new NoteDTO();
    }

    public NoteDTO delete(Long id) {
        return new NoteDTO();
    }

    public NoteDTO archive(Long id) {
        return new NoteDTO();
    }

    public NoteDTO unarchive(Long id) {
        return new NoteDTO();
    }

    public NoteDTO getArchived() {
        return new NoteDTO();
    }

}
