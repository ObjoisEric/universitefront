package fr.objois.universite.universitefront.enseignant.business;

import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.matiere.domain.Matiere;

import java.util.List;

public interface IEnseignantBusiness {

	public List<Enseignant> getAllEnseignant();

	public Enseignant getEnseignantDetail(Integer id);

	public void ajouteEnseignant(Enseignant enseignant);

	public void modifierEnseignant(Enseignant enseignant);

	List<Matiere> getListMatieresEnseignant(Integer idEnseignant);
}
