package fr.objois.universite.universitefront.note.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import lombok.Data;



@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Note {

	@JsonProperty("notePk")
	private NotePrimaryKey notePrimaryKey;

	@JsonProperty("note")
	private Double note;

	@JsonProperty("etudiant")
	private Etudiant etudiant;

	@JsonProperty("matiere")
	private Matiere matiere;





	
}
