package com.pala.NotesAppSpringBoot.controller;

import com.pala.NotesAppSpringBoot.dto.NoteDTO;
import com.pala.NotesAppSpringBoot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<NoteDTO>> index() {
        List<NoteDTO> response = noteService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<NoteDTO> create(@RequestBody NoteDTO note) {
        NoteDTO response = noteService.create(note);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<NoteDTO> edit(@PathVariable Long id, @RequestBody NoteDTO note) {
        NoteDTO response = noteService.edit(id, note);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<NoteDTO> delete(@PathVariable Long id) {
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/archive/{id}")
    public ResponseEntity<NoteDTO> archive(@PathVariable Long id) {
        NoteDTO response = noteService.archive(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/unarchive/{id}")
    public ResponseEntity<NoteDTO> unarchive(@PathVariable Long id) {
        NoteDTO response = noteService.unarchive(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/archived")
    public ResponseEntity<NoteDTO> archived() {
        NoteDTO response = noteService.getArchived();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
