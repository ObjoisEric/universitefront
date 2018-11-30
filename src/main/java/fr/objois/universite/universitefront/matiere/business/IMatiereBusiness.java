package fr.objois.universite.universitefront.matiere.business;

import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.matiere.domain.Matiere;

import java.util.List;

public interface IMatiereBusiness {

	public List<Matiere> getAllMatiere();

	public Matiere getDetailMatiere(Integer id);

	public void ajouterMatiere(Matiere matiere, Integer idEnseignant);

	public List<Enseignant> qetAllEnseignant();

	public void modifierMatiere(Matiere matiere, Integer idEnseignant);

	List<Matiere> getMatiereEnseignant(Integer idEnseignant);
}
