package com.pala.NotesAppSpringBoot.DTO;

public class NoteDTO {
    private Long id;
    private String title;
    private String content;
    private Boolean isArchived;

    public NoteDTO() {}

    public NoteDTO(Long id, String title, String content, Boolean isArchived) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isArchived = isArchived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }
}
