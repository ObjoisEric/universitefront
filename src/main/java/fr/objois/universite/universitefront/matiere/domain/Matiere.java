package fr.objois.universite.universitefront.matiere.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.note.domain.Note;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","notes"})
public class Matiere {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("numero")
    private Integer numeroMatiere;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("coef")
    private Integer coef;
    @JsonProperty("dateDebut")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @JsonProperty("dateFin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    @JsonProperty("enseignant")
    private Enseignant enseignant;
    @JsonProperty("notes")
    private List<Note> notes;





}
