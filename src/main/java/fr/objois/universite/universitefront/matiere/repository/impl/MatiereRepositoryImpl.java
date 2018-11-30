package fr.objois.universite.universitefront.matiere.repository.impl;

import fr.objois.universite.universitefront.enseignant.domain.Enseignant;
import fr.objois.universite.universitefront.matiere.domain.Matiere;
import fr.objois.universite.universitefront.matiere.repository.IMatiereRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Repository
public class MatiereRepositoryImpl implements IMatiereRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private String urlServer = "http://sonar:65000";
    private String urlBack = urlServer + "/matieres";

    @Override
    public List<Matiere> findAll() {

        return restTemplate.exchange(
                urlBack,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Matiere>>() {}
                ).getBody();
    }

    @Override
    public Matiere getOne(Integer id) {

        return restTemplate.getForObject(urlBack + "/" + id, Matiere.class);
    }

    @Override
    public void add(Matiere matiere) {
        restTemplate.postForObject(urlBack,matiere, Matiere.class);
    }

    @Override
    public void update(Matiere vraiMatiere) {
        restTemplate.put(urlBack+"/"+vraiMatiere.getId(), vraiMatiere,Matiere.class);
    }

    @Override
    public List<Matiere> getMatiereEnseignant(Integer idEnseignant) {
        return restTemplate.exchange(
                urlServer + "/enseignants/" + idEnseignant + "/matieres",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Matiere>>() {
                }).getBody();
    }
}
