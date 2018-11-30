package fr.objois.universite.universitefront.note.controller;

import fr.objois.universite.universitefront.note.domain.Note;
import org.springframework.ui.Model;

public interface INoteController {
	
	public String afficherAllNotes(Model model, Integer page);
	
	public String afficherNoteMatiere(Model model, Integer id);
	
	public String ajouterNote(Model model);
	
	public String ajouterNote(Model model, Note note, Integer idMatiere, Integer idEtudiant);
	
	public String noteDiff(Model model);

}
