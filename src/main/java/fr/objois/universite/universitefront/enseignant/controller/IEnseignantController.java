package fr.objois.universite.universitefront.enseignant.controller;

import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import org.springframework.ui.Model;

public interface IEnseignantController {

	public String afficherAllEnseignant(Model model);

	public String afficherDetailEnseignant(Model model, Integer id);

	public String ajouterEnseignant(Model model);

	public String ajouterEnseignant(Model model, Enseignant enseignant);
	
	public String modificationEnseignant(Model model, Integer id);
	
	public String modifierEnseignant(Model model, Enseignant enseignant);
	
	
}
