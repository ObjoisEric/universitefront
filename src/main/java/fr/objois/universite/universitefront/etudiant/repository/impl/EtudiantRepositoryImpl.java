package fr.objois.universite.universitefront.etudiant.repository.impl;

import fr.objois.universite.universitefront.etudiant.domain.Etudiant;
import fr.objois.universite.universitefront.etudiant.repository.IEtudiantRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EtudiantRepositoryImpl implements IEtudiantRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private String urlServer = "http://sonar:65000";
    private String urlBack = urlServer + "/etudiants";

    @Override
    public List<Etudiant> findAll() {

        return restTemplate.exchange(
                urlBack,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Etudiant>>(){}
        ).getBody();
    }

    @Override
    public Etudiant getOne(Integer id) {

        return restTemplate.getForObject(urlBack+"/"+id,Etudiant.class);
    }

    @Override
    public void add(Etudiant etudiant) {
        restTemplate.postForObject(urlBack,etudiant,Etudiant.class);
    }

    @Override
    public void update(Etudiant vraiEtudiant) {
        restTemplate.put(urlBack + "/" + vraiEtudiant.getId() ,vraiEtudiant,Etudiant.class);
    }
}
