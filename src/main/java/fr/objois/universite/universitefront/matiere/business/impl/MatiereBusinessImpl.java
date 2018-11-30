package fr.objois.universite.universitefront.matiere.business.impl;

import fr.objois.universite.universitefront.enseignant.business.IEnseignantBusiness;
import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.matiere.business.IMatiereBusiness;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import fr.objois.universite.universitefront.matiere.repository.IMatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereBusinessImpl implements IMatiereBusiness {
	
	@Autowired
	IMatiereRepository matiereRepository;
	@Autowired
	IEnseignantBusiness enseignantBusiness;

	@Override
	public List<Matiere> getAllMatiere() {
		return matiereRepository.findAll();
	}

	@Override
	public Matiere getDetailMatiere(Integer id) {

		return matiereRepository.getOne(id);
	}



	@Override
	public List<Enseignant> qetAllEnseignant() {
		return enseignantBusiness.getAllEnseignant();
	}

	@Override
	public void ajouterMatiere(Matiere matiere, Integer idEnseignant) {
		
		Enseignant enseignant = enseignantBusiness.getEnseignantDetail(idEnseignant);
		matiere.setEnseignant(enseignant);
		matiereRepository.add(matiere);
		
	}

	@Override
	public void modifierMatiere(Matiere matiere, Integer idEnseignant) {
		
		Enseignant enseignant = enseignantBusiness.getEnseignantDetail(idEnseignant);

		Matiere vraiMatiere = matiereRepository.getOne(matiere.getId());
		
		vraiMatiere.setNom(matiere.getNom());
		vraiMatiere.setEnseignant(enseignant);
		
		matiereRepository.update(vraiMatiere);
		
		
	}

	@Override
	public List<Matiere> getMatiereEnseignant(Integer idEnseignant) {
		return matiereRepository.getMatiereEnseignant(idEnseignant);
	}

}
