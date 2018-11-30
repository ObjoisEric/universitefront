package fr.objois.universite.universitefront.matiere.controller;

import fr.objois.universite.universitefront.matiere.domain.Matiere;
import org.springframework.ui.Model;

public interface IMatiereController {
	
	public String afficherAllMatiere(Model model);
	
	public String afficherDetailMatiere(Model model, Integer id);
	
	public String ajouterMatiere(Model model);
	
	public String ajouterMatiere(Model model, Matiere matiere, Integer idEnseignant);
	
	public String modificationMatiere(Model model, Integer id);
	
	public String modifierMatiere(Model model, Matiere matiere, Integer idEnseignant);

}
