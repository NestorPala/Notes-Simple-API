package com.pala.NotesAppSpringBoot.dto;

public class NoteDTO {
    private String title;
    private String content;
    private Boolean isArchived;

    public NoteDTO() {}

    public NoteDTO(String title, String content, Boolean isArchived) {
        this.title = title;
        this.content = content;
        this.isArchived = isArchived;
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
