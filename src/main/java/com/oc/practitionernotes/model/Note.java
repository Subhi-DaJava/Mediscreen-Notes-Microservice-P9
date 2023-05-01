package com.oc.practitionernotes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notes")
public class Note {
    @Id
    private String id;
    private Long patId;
    private String patLastName;
    private String comment;
    private LocalDateTime localDateTime;

    public Note() {
    }

    public Note(Long patId, String patLastName, String comment) {
        this.patId = patId;
        this.patLastName = patLastName;
        this.comment = comment;
        this.localDateTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getPatLastName() {
        return patLastName;
    }

    public void setPatLastName(String patLastName) {
        this.patLastName = patLastName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", patId=" + patId +
                ", patLastName='" + patLastName + '\'' +
                ", comment='" + comment + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
