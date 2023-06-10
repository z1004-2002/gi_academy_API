package com.vetrix.GI_ACADEMY.chapitre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChapitreService {
    private final ChapitreRepository repository;

    public ChapitreService(ChapitreRepository repository) {
        this.repository = repository;
    }

    public Chapitre add(Chapitre chapitre){
        return repository.save(chapitre);
    }
    public List<Chapitre> getAll(){
        return repository.findAll();
    }
    public Chapitre getById(UUID id){
        return repository.findById(id).get();
    }
    public Chapitre update(UUID id,Chapitre chapitre){
        repository.findById(id).map(chap ->{
            chap.setNom(chapitre.getNom());
            chap.setDescription(chapitre.getDescription());
            return repository.save(chap);
        });
        return chapitre;
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}