package fr.objois.universite.universitefront.etudiant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.objois.universite.universitefront.note.domain.Note;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Etudiant {

	@JsonProperty("id")
	Integer id;
	@JsonProperty("numero")
	Integer numeroEtudiant;
	@JsonProperty("nom")
	String nom;
	@JsonProperty("prenom")
	String prenom;
	@JsonProperty("dateNaissance")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date dateNaissance;
	@JsonProperty("sexe")
	String sexe;
	@JsonProperty("notes")
	@JsonIgnore
	private List<Note> notes;


	
	
	
	

}
