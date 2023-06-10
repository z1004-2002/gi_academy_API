package com.vetrix.GI_ACADEMY.sous_systeme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SousService {
    @Autowired
    private final SousRepository repository;

    public SousService(SousRepository repository) {
        this.repository = repository;
    }

    public SousSysteme addSous(SousSysteme sousSysteme){
        return repository.save(sousSysteme);
    }
    public List<SousSysteme> getAll(){
        return repository.findAll();
    }
    public SousSysteme getById(UUID id){
        return repository.findById(id).get();
    }
    public SousSysteme update(UUID id,SousSysteme sousSysteme){
        repository.findById(id).map(sous ->{
            sous.setNom(sousSysteme.getNom());
            sous.setDescription(sousSysteme.getDescription());
            return repository.save(sous);
        });
        return sousSysteme;
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}
