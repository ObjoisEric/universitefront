package fr.objois.universite.universitefront.note.repository;

import fr.objois.universite.universitefront.note.domain.Note;
import fr.objois.universite.universitefront.note.domain.NotePrimaryKey;

import java.util.List;

public interface INoteRepository{
	List<Note> findAll();

	Note getOne(NotePrimaryKey notePrimaryKey);

	void save(Note note);

	void update(Note note);

	List<Note> findByEtudiantIdAndNoteLessThan(Integer id, double v);

	List<Note> findByNoteLessThan(double d);

	List<Note> getNoteEtudiant(Integer id);

	List<Note> getNoteInfValue(Double value);
}
