package fr.objois.universite.universitefront.matiere.repository;

import fr.objois.universite.universitefront.matiere.domain.Matiere;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IMatiereRepository {

    List<Matiere> findAll();

    Matiere getOne(Integer id);

    void add(Matiere matiere);

    void update(Matiere vraiMatiere);

    List<Matiere> getMatiereEnseignant(Integer idEnseignant);
}
