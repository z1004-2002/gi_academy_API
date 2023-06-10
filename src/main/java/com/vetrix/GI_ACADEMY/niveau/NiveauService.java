package com.vetrix.GI_ACADEMY.niveau;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NiveauService {
    private final NiveauRepository repository;

    public NiveauService(NiveauRepository repository) {
        this.repository = repository;
    }
    public Niveau add(Niveau niveau){
        return repository.save(niveau);
    }
    public List<Niveau> getAll(){
        return repository.findAll();
    }
    public Niveau getById(UUID id){
        return repository.findById(id).get();
    }
    public Niveau update(UUID id, Niveau niveau){
        repository.findById(id).map(niv -> {
            niv.setNom(niveau.getNom());
            niv.setDescription(niv.getDescription());
            return repository.save(niv);
        });
        return niveau;
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}
