package fr.objois.universite.universitefront.note.business.impl;

import fr.objois.universite.universitefront.etudiant.business.IEtudiantBusiness;
import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import fr.objois.universite.universitefront.matiere.business.IMatiereBusiness;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import fr.objois.universite.universitefront.note.business.INoteBusiness;
import fr.objois.universite.universitefront.note.domain.Note;
import fr.objois.universite.universitefront.note.domain.NotePrimaryKey;
import fr.objois.universite.universitefront.note.repository.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class NoteBusinessImpl implements INoteBusiness{
	
	public static final Double CONSTANTE_15 = 15.0;
	@Autowired
	INoteRepository noteRepository;
	@Autowired
	IMatiereBusiness matiereBusiness;
	@Autowired
	IEtudiantBusiness etudiantBusiness;

	@Override
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}


	@Override
	public Matiere getMatiere(Integer id) {
		return matiereBusiness.getDetailMatiere(id);
	}
	


	@Override
	public List<Matiere> getAllMatiere() {
		

		return matiereBusiness.getAllMatiere();
	}


	@Override
	public List<Etudiant> getAllEtudiant() {
		return etudiantBusiness.getAllEtudiant();
	}


	@Override
	public void ajouterNote(Note note, Integer idMatiere, Integer idEtudiant) {
		Matiere matiere = matiereBusiness.getDetailMatiere(idMatiere);
		Etudiant etudiant = etudiantBusiness.getDetailEtudiant(idEtudiant);
		NotePrimaryKey notePrimaryKey = new NotePrimaryKey();		
		
		notePrimaryKey.setIdEtudiant(idEtudiant);
		notePrimaryKey.setIdMatiere(idMatiere);
		
		note.setEtudiant(etudiant);
		note.setMatiere(matiere);
		note.setNotePrimaryKey(notePrimaryKey);
		
		noteRepository.save(note);
		
	}


	@Override
	public List<Etudiant> getEtudiantDiff() {
		Double value = 10.0;
		List<Note> listNoteInfValue = noteRepository.getNoteInfValue(value);
		List<Etudiant> listEtudiantDiff = new ArrayList<>();
		




		return getEtudiantInfDix(listEtudiantDiff);
	}


	private List<Etudiant> getEtudiantInfDix(List<Etudiant> listEtudiantDiff) {
		for (Iterator<Etudiant> iterator = listEtudiantDiff.iterator(); iterator.hasNext();) {
			Etudiant etudiant = iterator.next();
			List<Note> listNote = getNoteInfDix(etudiant.getNotes());
			if (listNote.isEmpty()) {
				iterator.remove();
			}else {
				etudiant.setNotes(listNote);
			}
		}
		return listEtudiantDiff;
	}


	private List<Note> getNoteInfDix(List<Note> notes) {

		notes.removeIf((Note note) -> note.getNote() >= 10);
		return notes;
	}

	@Override
	public Integer getNbrPage() {

		if (getAllNotes() != null) {
			return (int) (Math.ceil(getAllNotes().size()/getNoteParPage()));
		}else {
			return 1;
		}
	}

	@Override
	public List<Note> getNoteEtudiant(Integer id) {
		List<Note> listNoteEtudiant ;
		listNoteEtudiant = noteRepository.getNoteEtudiant(id);
		return listNoteEtudiant;


	}

	@Override
	public List<Note> findByEtudiantIdAndNoteLessThan(Integer id, double v) {
		return noteRepository.findByEtudiantIdAndNoteLessThan(id,v);
	}

	@Override
	public List<Note> getNotePage(Integer page) {
		List<Note> listeAllNote = getAllNotes();
		List<Note> listeNote = new ArrayList<>();
		Integer debutPage =  getDebutPage(page);
		Integer finPage = getFinPage(page);
		int i = debutPage;

		if (listeAllNote != null){
			for (Iterator<Note> iterator = listeAllNote.listIterator(i); iterator.hasNext();) {
				iterator.next();

				if(i >= finPage){
					break;
				}
				listeNote.add(listeAllNote.get(i));
				i++;
			}
			return listeNote;
		}else {
			return listeNote;
		}
	}


	private Integer getDebutPage(Integer page) {



		return (int)((getNoteParPage()*page) - getNoteParPage());
	}


	private Integer getFinPage(Integer page) {


		return (int)((getNoteParPage()*page)-1.0);
	}

	private Double getNoteParPage() {

		return CONSTANTE_15;
	}



}
