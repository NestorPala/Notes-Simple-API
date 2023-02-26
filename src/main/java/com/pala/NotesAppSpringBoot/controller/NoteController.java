package com.pala.NotesAppSpringBoot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @GetMapping
    public String index() {
        return "index";
    }
    @PostMapping("/create")
    public String create() {
        return "create";
    }
    @PatchMapping("/edit/{id}")
    public String edit(@PathVariable Long id) {
        return "edit";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return "delete";
    }
    @PatchMapping("/archive/{id}")
    public String archive(@PathVariable Long id) {
        return "archive";
    }
    @PatchMapping("/unarchive/{id}")
    public String unarchive(@PathVariable Long id) {
        return "unarchive";
    }
    @GetMapping("/archived")
    public String archived() {
        return "archived";
    }
}
