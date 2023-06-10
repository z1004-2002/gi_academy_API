package com.vetrix.GI_ACADEMY.lecon;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LeconService {
    private final LeconRepository repository;

    public LeconService(LeconRepository repository) {
        this.repository = repository;
    }
    public Lecon add(Lecon lecon){
        return repository.save(lecon);
    }
    public List<Lecon> getAll(){
        return repository.findAll();
    }
    public Lecon getById(UUID id){
        return repository.findById(id).get();
    }
    public Lecon update(UUID id,Lecon lecon){
        repository.findById(id).map(lec -> {
            lec.setNom(lecon.getNom());
            lec.setDescription(lecon.getDescription());
            return repository.save(lec);
        });
        return lecon;
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}