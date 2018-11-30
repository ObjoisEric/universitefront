package fr.objois.universite.universitefront.matiere.controller.impl;

import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.matiere.business.IMatiereBusiness;
import fr.objois.universite.universitefront.matiere.controller.IMatiereController;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MatiereControllerImpl implements IMatiereController {
	
	@Autowired
	IMatiereBusiness matiereBusiness;

	@Override
	@RequestMapping("/matieres")
	public String afficherAllMatiere(Model model) {
		
		List<Matiere> listeMatiere = matiereBusiness.getAllMatiere();
		model.addAttribute("listeMatiere",listeMatiere);
		
		return "matiere/matieres";
	}

	@Override
	@RequestMapping("/matiere")
	public String afficherDetailMatiere(Model model, @RequestParam Integer id) {		
		
		Matiere detailMatiere = matiereBusiness.getDetailMatiere(id);		
		model.addAttribute("detailMatiere",detailMatiere);
		
		Enseignant listEnseignant = detailMatiere.getEnseignant();
		model.addAttribute("listEnseignant",listEnseignant);
		
		return "matiere/matiere";
	}

	@Override
	@RequestMapping("/ajouterMatiere")
	public String ajouterMatiere(Model model) {
		Matiere matiere = new Matiere();
		model.addAttribute("matiere",matiere);
		
		List<Enseignant> listeEnseignant = matiereBusiness.qetAllEnseignant();		
		model.addAttribute("listeEnseignant",listeEnseignant);
		
		return "matiere/ajouterMatiere";
	}

	@Override
	@PostMapping("/ajouterMatiere")
	public String ajouterMatiere(Model model,@ModelAttribute Matiere matiere,@RequestParam Integer idEnseignant) {
		
		
		
		matiereBusiness.ajouterMatiere(matiere,idEnseignant);
		return "redirect:/matieres";
	}

	@Override
	@RequestMapping("/modifierMatiere")
	public String modificationMatiere(Model model, Integer id) {
		Matiere matiere = matiereBusiness.getDetailMatiere(id);
		model.addAttribute("matiere",matiere);
		
		List<Enseignant> listeEnseignant = matiereBusiness.qetAllEnseignant();		
		model.addAttribute("listeEnseignant",listeEnseignant);
		
		return "matiere/modifierMatiere";
	}

	@Override
	@PostMapping("/modifierMatiere")
	public String modifierMatiere(Model model,@ModelAttribute Matiere matiere,@RequestParam Integer idEnseignant) {
		
		matiereBusiness.modifierMatiere(matiere, idEnseignant);
		
		return "redirect:/matieres";
	}
	
	
	

}
