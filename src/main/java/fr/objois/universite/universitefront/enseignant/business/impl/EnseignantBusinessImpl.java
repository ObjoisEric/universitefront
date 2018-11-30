package fr.objois.universite.universitefront.enseignant.business.impl;

import fr.objois.universite.universitefront.enseignant.business.IEnseignantBusiness;
import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.enseignant.repository.IEnseignantRepository;
import fr.objois.universite.universitefront.matiere.business.IMatiereBusiness;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantBusinessImpl implements IEnseignantBusiness {
	
	@Autowired
	IEnseignantRepository enseignantRepository;
	@Autowired
	IMatiereBusiness matiereBusiness;

	@Override
	public List<Enseignant> getAllEnseignant() {

		return enseignantRepository.findAll();
	}

	@Override
	public Enseignant getEnseignantDetail(Integer id) {

		return enseignantRepository.getOne(id);
	}

	@Override
	public void ajouteEnseignant(Enseignant enseignant) {
		enseignantRepository.add(enseignant);
		
	}

	@Override
	public void modifierEnseignant(Enseignant enseignant) {
		Enseignant vraiEns = enseignantRepository.getOne(enseignant.getId());
		vraiEns.setNom(enseignant.getNom());
		vraiEns.setPrenom(enseignant.getPrenom());
		vraiEns.setGrade(enseignant.getGrade());
		
		enseignantRepository.update(vraiEns);
		
	}

	@Override
	public List<Matiere> getListMatieresEnseignant(Integer idEnseignant) {

		return matiereBusiness.getMatiereEnseignant(idEnseignant);
	}

}
