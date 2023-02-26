package com.pala.NotesAppSpringBoot.service;

import com.pala.NotesAppSpringBoot.domain.Note;
import com.pala.NotesAppSpringBoot.dto.NoteDTO;
import com.pala.NotesAppSpringBoot.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<NoteDTO> getAll() {
        List<Note> noteList = noteRepository.findAll();
        List<NoteDTO> notes = new ArrayList<>();

        noteList.forEach(note -> {
            NoteDTO noteDTO = modelMapper.map(note, NoteDTO.class);
            notes.add(noteDTO);
        });

        return notes;
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
