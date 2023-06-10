package com.vetrix.GI_ACADEMY.systeme;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SystemeService {
    private final SystemeRepository repository;
    public SystemeService(SystemeRepository repository) {
        this.repository = repository;
    }
    public Systeme addSysteme(Systeme systeme){
        return repository.save(systeme);
    }
    public List<Systeme> getAllSysteme() {
        return repository.findAll();
    }
    public Systeme findById(UUID id){
        return repository.findById(id).get();
    }
    public Systeme update(UUID id, Systeme systeme){
        repository.findById(id).map(syst ->{
            syst.setNom(systeme.getNom());
            syst.setDescription(systeme.getDescription());
            return repository.save(syst);
        });
        return systeme;
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}