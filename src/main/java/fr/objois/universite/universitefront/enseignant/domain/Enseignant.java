package fr.objois.universite.universitefront.enseignant.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","listMatieres"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Enseignant {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("numero")
    private Integer numero;
    @JsonProperty("nom")
    private String nom;
    @JsonProperty("prenom")
    private String prenom;
    @JsonProperty("dateNaissance")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @JsonProperty("sexe")
    private String sexe;
    @JsonProperty("grade")
    private String grade;
    @JsonProperty("dateEmbauche")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEmbauche;
    @JsonProperty("matieres")
    private List<Matiere> listMatieres;





}
