package com.pala.NotesAppSpringBoot.service;

import com.pala.NotesAppSpringBoot.domain.Note;
import com.pala.NotesAppSpringBoot.dto.NoteDTO;
import com.pala.NotesAppSpringBoot.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;


@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<NoteDTO> getAll() {
        List<Note> noteList = noteRepository.findAll();
        return getNoteDTOListFrom(noteList);
    }

    public List<NoteDTO> getByFilters(String title, String content, String sort) {
        List<Note> notes = switch (sort) {
            case "title" -> noteRepository.findAllByOrderByTitleAsc();
            case "-title" -> noteRepository.findAllByOrderByTitleDesc();
            case "content" -> noteRepository.findAllByOrderByContentAsc();
            case "-content" -> noteRepository.findAllByOrderByContentDesc();
            default -> noteRepository.findAll();
        };

        Predicate<Note> noteFilter;

        if (!title.equals(" ") && !content.equals(" ")) {
            noteFilter = note -> note.getTitle().equals(title) && note.getContent().equals(content);
        } else if (!title.equals(" ")) {
            noteFilter = note -> note.getTitle().equals(title);
        } else if (!content.equals(" ")) {
            noteFilter = note -> note.getContent().equals(content);
        } else {
            noteFilter = note -> true;
        }

        notes = notes.stream().filter(noteFilter).toList();

        return getNoteDTOListFrom(notes);
    }

    public NoteDTO create(NoteDTO note) {
        note.setArchived(false);
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
        if (noteList == null) {
            return Collections.emptyList();
        }
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
