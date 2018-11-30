package fr.objois.universite.universitefront.enseignant.repository;

import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IEnseignantRepository{


    List<Enseignant> findAll();

    Enseignant getOne(Integer id);

    void add(Enseignant vraiEns);

    void update(Enseignant vraiEns);
}
