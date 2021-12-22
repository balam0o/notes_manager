package com.worksample.sample.dao;
import com.worksample.sample.models.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
@Transactional
public class NoteDaoImp implements NoteDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Note> getNotes() {
        String query = "FROM Note";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Long id) {
        Note note = entityManager.find(Note.class, id);
        entityManager.remove(note);
    }

    @Override
    public void create(Note note) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        note.setCreatedat(dtf.format(LocalDateTime.now()));
        entityManager.merge(note);
    }

    @Override
    public Note getNote(Long id) {
        Note note = entityManager.find(Note.class, id);
        return note;
    }

    @Override
    public void deleteNotes() {
        Query query = entityManager.createNativeQuery("DELETE FROM Notes");
        query.executeUpdate();
    }

    @Override
    public void updateNote(Long id, Note note) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Note oldnote = entityManager.find(Note.class, id);
        note.setId(oldnote.getId());
        note.setCreatedat(oldnote.getCreatedat());
        note.setUpdatedat(dtf.format(LocalDateTime.now()));
        entityManager.merge(note);
    }

    @Override
    public void updateNotes(List<Note> note) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Note nnote = new Note();
        String aux;
        for (int i=0;i<note.size();i++) {
            String query = "SELECT createdat FROM Note where id="+note.get(i).getId();
            entityManager.createQuery(query);
            aux = String.valueOf(entityManager.createQuery(query).getSingleResult());
            nnote = note.get(i);
            nnote.setCreatedat(aux);
            nnote.setUpdatedat(dtf.format(LocalDateTime.now()));
            entityManager.merge(nnote);
        }
    }

}
