package fr.objois.universite.universitefront.enseignant.repository.impl;

import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.enseignant.repository.IEnseignantRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class EnseignantRepositoryImpl implements IEnseignantRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private String urlBack = "http://sonar:65000/enseignants";

    @Override
    public List<Enseignant> findAll() {

        return restTemplate.exchange(
                urlBack,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Enseignant>>() {
                }
        ).getBody();
    }

    @Override
    public Enseignant getOne(Integer id) {
        return restTemplate.getForObject(urlBack + "/" + id, Enseignant.class);
    }

    @Override
    public void add(Enseignant vraiEns) {
        restTemplate.postForObject(urlBack, vraiEns,Enseignant.class);
    }

    @Override
    public void update(Enseignant vraiEns) {

        restTemplate.put(urlBack + "/"+vraiEns.getId(), vraiEns,Enseignant.class);
    }


}
