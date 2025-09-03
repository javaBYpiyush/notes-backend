package com.nt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "NOTE_TBL")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private boolean isPublic = false;

    @Column(unique = true)
    private String shareId;

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
        if (isPublic && this.shareId == null) {
            this.shareId = UUID.randomUUID().toString();
        }
        if (!isPublic) {
            this.shareId = null;
        }
    }

    // getters and setters
}

