package fr.objois.universite.universitefront.etudiant.repository;

import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IEtudiantRepository{

    List<Etudiant> findAll();

    Etudiant getOne(Integer id);

    void add(Etudiant etudiant);

    void update(Etudiant vraiEtudiant);
}
