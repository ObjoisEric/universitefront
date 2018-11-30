package fr.objois.universite.universitefront.note.business;

import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import fr.objois.universite.universitefront.note.domain.Note;

import java.util.List;

public interface INoteBusiness {

	public List<Note> getAllNotes();


	public Matiere getMatiere(Integer id);


	public List<Matiere> getAllMatiere();


	public List<Etudiant> getAllEtudiant();


	public void ajouterNote(Note note, Integer idMatiere, Integer idEtudiant);

	public List<Etudiant> getEtudiantDiff();

	public List<Note> getNotePage(Integer page);

	public Integer getNbrPage();

	List<Note> getNoteEtudiant(Integer id);

	List<Note> findByEtudiantIdAndNoteLessThan(Integer id, double v);
}
