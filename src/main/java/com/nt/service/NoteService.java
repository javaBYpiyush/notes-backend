package com.nt.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.model.Note;
import com.nt.repository.NoteRepository;

@Service
public class NoteService {
    private final NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    public List<Note> findAll() {
        return repo.findAll();
    }

    public Optional<Note> findById(Integer id) {
        return repo.findById(id);
    }

    public Optional<Note> findByShareId(String shareId) {
        return repo.findByShareId(shareId);
    }

    public Note save(Note note) {
        return repo.save(note);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
