package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Optional<Note> findByShareId(String shareId);
}