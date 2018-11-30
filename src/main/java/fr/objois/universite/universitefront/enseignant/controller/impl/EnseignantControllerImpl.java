package fr.objois.universite.universitefront.enseignant.controller.impl;

import fr.objois.universite.universitefront.enseignant.business.IEnseignantBusiness;
import fr.objois.universite.universitefront.enseignant.controller.IEnseignantController;
import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
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
public class EnseignantControllerImpl implements IEnseignantController{
	
	@Autowired
	IEnseignantBusiness enseignantBusiness;

	@Override
	@RequestMapping("/enseignants")
	public String afficherAllEnseignant(Model model) {
		
		List<Enseignant> listEnseignant = enseignantBusiness.getAllEnseignant();
		
		model.addAttribute("listEnseignant",listEnseignant);
		return "enseignant/enseignants";
	}

	@Override
	@RequestMapping("/enseignant")
	public String afficherDetailEnseignant(Model model, @RequestParam Integer id) {
		
		Enseignant enseignantDetail = enseignantBusiness.getEnseignantDetail(id);
		model.addAttribute("enseignantDetail",enseignantDetail);
		
		List<Matiere> listMatiere = enseignantBusiness.getListMatieresEnseignant(enseignantDetail.getId());
		model.addAttribute("listMatiere",listMatiere);
		return "enseignant/enseignant";
	}

	@Override
	@RequestMapping("/ajouterEnseignant")
	public String ajouterEnseignant(Model model) {
		Enseignant enseignant = new Enseignant();
		enseignant.setSexe("M");
		model.addAttribute("enseignant", enseignant);
		return "enseignant/ajouterEnseignant";
	}

	@Override
	@PostMapping("/ajouterEnseignant")
	public String ajouterEnseignant(Model model,@ModelAttribute Enseignant enseignant) {
		
			enseignantBusiness.ajouteEnseignant(enseignant);
			return "redirect:/enseignants";
		
	}

	@Override
	@RequestMapping("/modifierEnseignant")
	public String modificationEnseignant(Model model,@RequestParam Integer id) {
		Enseignant enseignant = enseignantBusiness.getEnseignantDetail(id);
		model.addAttribute("enseignant",enseignant);
		
		return "enseignant/modifierEnseignant";
	}

	@Override
	@PostMapping("/modifierEnseignant")
	public String modifierEnseignant(Model model, Enseignant enseignant) {
		enseignantBusiness.modifierEnseignant(enseignant);
		return "redirect:/enseignants";
	}
	
	
	
	

}
