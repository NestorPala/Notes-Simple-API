package com.pala.NotesAppSpringBoot.service;

import com.pala.NotesAppSpringBoot.domain.Note;
import com.pala.NotesAppSpringBoot.dto.NoteDTO;
import com.pala.NotesAppSpringBoot.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<NoteDTO> getAll() {
        List<Note> noteList = noteRepository.findAll();
        return getNoteDTOListFrom(noteList);
    }

    public NoteDTO create(NoteDTO note) {
        Note newNote = noteRepository.save(modelMapper.map(note, Note.class));
        return modelMapper.map(newNote, NoteDTO.class);
    }

    public NoteDTO edit(Long id, NoteDTO note) {
        Optional<Note> _storedNote = noteRepository.findById(id);
        if(_storedNote.isEmpty()) {
            throw new RuntimeException("Note not found");
        }
        Note storedNote = _storedNote.get();
        if (note.getTitle() != null) {
            storedNote.setTitle(note.getTitle());
        }
        if (note.getContent() != null) {
            storedNote.setContent(note.getContent());
        }
        noteRepository.save(storedNote);
        return modelMapper.map(storedNote, NoteDTO.class);
    }

    public String delete(Long id) {
        Optional<Note> _storedNote = noteRepository.findById(id);
        if(_storedNote.isEmpty()) {
            throw new RuntimeException("Note not found");
        }
        noteRepository.deleteById(id);
        return "Note deleted successfully!";
    }

    public NoteDTO archive(Long id) {
        return setArchived(id,true);
    }

    public NoteDTO unarchive(Long id) {
        return setArchived(id,false);
    }

    public List<NoteDTO> getArchived() {
        List<Note> archivedNotes = noteRepository.findNotesByIsArchived(true);
        return archivedNotes
                .stream()
                .map(archivedNote -> modelMapper.map(archivedNote, NoteDTO.class))
                .toList();
    }

    private List<NoteDTO> getNoteDTOListFrom(List<Note> noteList) {
        List<NoteDTO> notes = new ArrayList<>();

        noteList.forEach(note -> {
            NoteDTO noteDTO = modelMapper.map(note, NoteDTO.class);
            notes.add(noteDTO);
        });

        return notes;
    }

    private NoteDTO setArchived(Long id, Boolean isArchived) {
        Optional<Note> _storedNote = noteRepository.findById(id);
        if(_storedNote.isEmpty()) {
            throw new RuntimeException("Note not found");
        }
        Note storedNote = _storedNote.get();
        storedNote.setArchived(isArchived);
        return modelMapper.map(storedNote, NoteDTO.class);
    }
}
