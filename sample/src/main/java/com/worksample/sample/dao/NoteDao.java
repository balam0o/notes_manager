package com.worksample.sample.dao;
import com.worksample.sample.models.Note;
import java.util.List;

public interface NoteDao {

    List<Note> getNotes();

    void delete(Long id);

    void create(Note note);

    Note getNote(Long id);

    void deleteNotes();

    void updateNote(Long id, Note note);

    void updateNotes(List<Note> note);
}
