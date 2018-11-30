package fr.objois.universite.universitefront.etudiant.controller;

import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import org.springframework.ui.Model;

public interface IEtudiantController {
	
	public String aficherAllEtudiant(Model model);
	
	public String afficherDetailEtudiant(Model model, Integer id);
	
	public String ajouterEtudiant(Model model);
	
	public String ajouterEtudiant(Model model, Etudiant etudiant);
	
	public String modificationEtudiant(Model model, Integer id);
	
	public String modifierEtudiant(Model model, Etudiant etudiant);

}
