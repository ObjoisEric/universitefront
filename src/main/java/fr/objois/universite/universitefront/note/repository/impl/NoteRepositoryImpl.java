package fr.objois.universite.universitefront.note.repository.impl;

import fr.objois.universite.universitefront.note.domain.Note;
import fr.objois.universite.universitefront.note.domain.NotePrimaryKey;
import fr.objois.universite.universitefront.note.repository.INoteRepository;
import fr.objois.universite.universitefront.utils.ListUrl;
import fr.objois.universite.universitefront.utils.UrlBack;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Repository
public class NoteRepositoryImpl implements INoteRepository {

    private RestTemplate restTemplate = new RestTemplate();
    private UrlBack urlServer= ListUrl.url.getUrl();
    private String urlBack = urlServer.getUrl() + "/notes";




    @Override
    public List<Note> findAll() {

        return restTemplate.exchange(
                urlBack,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Note>>() {
                }
        ).getBody();
    }

    @Override
    public Note getOne(NotePrimaryKey notePrimaryKey) {

        return restTemplate.getForObject(
                urlBack + "/" + notePrimaryKey.getIdEtudiant() + "," + notePrimaryKey.getIdMatiere(),
                Note.class);
    }

    @Override
    public void save(Note note) {

        restTemplate.postForObject(urlBack,note,Note.class);

    }

    @Override
    public void update(Note note) {

        restTemplate.put(
                urlBack + "/" +note.getNotePrimaryKey().getIdEtudiant() + "," + note.getNotePrimaryKey().getIdMatiere(),
                note,
                Note.class
        );

    }

    @Override
    public List<Note> findByEtudiantIdAndNoteLessThan(Integer id, double v) {

        return restTemplate.exchange(
                urlServer.getUrl() +"/etudiants/"+id+"/notes?inf="+v,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Note>>() {
                }
        ).getBody();

    }

    @Override
    public List<Note> findByNoteLessThan(double d) {

        return null;

    }

    @Override
    public List<Note> getNoteEtudiant(Integer id) {


        return restTemplate.exchange(
                urlBack + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Note>>() {
                }
        ).getBody();
    }

    @Override
    public List<Note> getNoteInfValue(Double value) {
        return restTemplate.exchange(
                urlBack + "?=" + value,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Note>>() {
                }
        ).getBody();
    }
}
