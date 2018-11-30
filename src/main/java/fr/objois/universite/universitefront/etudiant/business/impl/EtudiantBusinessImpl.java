package fr.objois.universite.universitefront.etudiant.business.impl;

import fr.objois.universite.universitefront.etudiant.business.IEtudiantBusiness;
import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import fr.objois.universite.universitefront.etudiant.repository.IEtudiantRepository;
import fr.objois.universite.universitefront.note.business.INoteBusiness;
import fr.objois.universite.universitefront.note.domain.Note;
import fr.objois.universite.universitefront.note.repository.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantBusinessImpl implements IEtudiantBusiness{
	
	@Autowired
	IEtudiantRepository etudiantRepository;
	@Autowired
	INoteBusiness noteBusiness;

	@Override
	public List<Etudiant> getAllEtudiant() {

		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant getDetailEtudiant(Integer id) {

		return etudiantRepository.getOne(id);
	}

	@Override
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiantRepository.add(etudiant);
		
	}

	@Override
	public void modifierEtudiant(Etudiant etudiant) {
		Etudiant vraiEtudiant = etudiantRepository.getOne(etudiant.getId());
		vraiEtudiant.setNom(etudiant.getNom());
		vraiEtudiant.setPrenom(etudiant.getPrenom());

		etudiantRepository.update(vraiEtudiant);
	}

	@Override
	public List<Note> getNoteInfdixEtudiant(Integer id) {		
		
 		return noteBusiness.findByEtudiantIdAndNoteLessThan(id, 10.0);
	}

	@Override
	public List<Note> getNoteEtudiant(Integer id) {

		return noteBusiness.getNoteEtudiant(id);
	}


}
