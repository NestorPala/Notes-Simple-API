package com.pala.NotesAppSpringBoot.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "is_archived")
    @NotNull
    private Boolean isArchived; //in JSON use: "archived"

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    protected Note() {}

    public Note(Long id, String title, String content, Boolean isArchived) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isArchived = isArchived;
        this.updatedAt = null;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}