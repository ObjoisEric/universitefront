package fr.objois.universite.universitefront.note.controller.impl;

import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import fr.objois.universite.universitefront.note.business.INoteBusiness;
import fr.objois.universite.universitefront.note.controller.INoteController;
import fr.objois.universite.universitefront.note.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class NoteControllerImpl implements INoteController {
	
	@Autowired
	INoteBusiness noteBusiness;

	@Override
	@RequestMapping("/notes")
	public String afficherAllNotes(Model model, Integer page) {

		List<Note> listeNote = noteBusiness.getNotePage(page);
		model.addAttribute("listeNote",listeNote);

		Integer nbrPage = noteBusiness.getNbrPage();
		model.addAttribute("nbrPage", nbrPage);


		return "note/notes";
	}

	@Override
	@RequestMapping("/noteMatiere")
	public String afficherNoteMatiere(Model model, Integer id) {
		
		Matiere matiere = noteBusiness.getMatiere(id);
		model.addAttribute("matiere",matiere);
		
		return "note/noteMatiere";
	}

	@Override
	@RequestMapping("/ajouterNote")
	public String ajouterNote(Model model) {
		
		List<Note> listeNote = noteBusiness.getAllNotes();
		model.addAttribute("listeNote",listeNote);
		
		List<Matiere> listeMatiere = noteBusiness.getAllMatiere();
		model.addAttribute("listeMatiere",listeMatiere);
		
		List<Etudiant> listeEtudiant = noteBusiness.getAllEtudiant();
		model.addAttribute("listeEtudiant",listeEtudiant);
		
		
		Note note = new Note();
		model.addAttribute("note",note);
		 
		return "note/ajouterNote";
	}

	@Override
	@PostMapping("/ajouterNote")
	public String ajouterNote(Model model,@ModelAttribute Note note,@RequestParam Integer idMatiere,@RequestParam Integer idEtudiant) {
		
		noteBusiness.ajouterNote(note,idMatiere,idEtudiant);
	
		return "redirect:/notes?page=1";
	}

	@Override
	@RequestMapping("/notesDiff")
	public String noteDiff(Model model) {
		List<Etudiant> listEtudiantDiff = noteBusiness.getEtudiantDiff();
		model.addAttribute("listEtudiantDiff",listEtudiantDiff);
		
		
		return "note/notesDiff";
	}

}
