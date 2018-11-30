package fr.objois.universite.universitefront.etudiant.business;

import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import fr.objois.universite.universitefront.note.domain.Note;

import java.util.List;

public interface IEtudiantBusiness {

	public List<Etudiant> getAllEtudiant();

	public Etudiant getDetailEtudiant(Integer id);

	public void ajouterEtudiant(Etudiant etudiant);

	public void modifierEtudiant(Etudiant etudiant);

	public List<Note> getNoteInfdixEtudiant(Integer id);


	List<Note> getNoteEtudiant(Integer id);
}
