package com.worksample.sample.controllers;
import com.worksample.sample.dao.NoteDao;
import com.worksample.sample.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteDao noteDao;

    @RequestMapping(value = "api/notes", method = RequestMethod.POST)
    public void createNote(@RequestBody Note note) { noteDao.create(note); }

    @RequestMapping(value = "api/notes", method = RequestMethod.GET)
    public List<Note> getNotes() { return noteDao.getNotes(); }

    @RequestMapping(value = "api/notes/{id}", method = RequestMethod.PUT)
    public void updateNote(@PathVariable Long id, @RequestBody Note note) { noteDao.updateNote(id, note); }

    @RequestMapping(value = "api/notes/{id}", method = RequestMethod.GET)
    public Note getNote(@PathVariable Long id) { return noteDao.getNote(id); }

    @RequestMapping(value = "api/notes/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable Long id) { noteDao.delete(id); }

    @RequestMapping(value = "api/notes", method = RequestMethod.DELETE)
    public void deleteNotes() { noteDao.deleteNotes(); }

    @RequestMapping(value = "api/bulkUpdate/notes", method = RequestMethod.PUT)
    public void updateNotes(@RequestBody List<Note> note) { noteDao.updateNotes(note); }
}
