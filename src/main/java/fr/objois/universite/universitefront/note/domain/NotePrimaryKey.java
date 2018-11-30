package fr.objois.universite.universitefront.note.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class NotePrimaryKey implements Serializable {

	private static final long serialVersionUID = -3960755370829956602L;
	@JsonProperty("idEtudiant")
	private Integer idEtudiant;
	@JsonProperty("idMatiere")
	private Integer idMatiere;


	
}
