package com.vetrix.GI_ACADEMY.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CycleService {
    private final CylceRepository repository;

    @Autowired
    public CycleService(CylceRepository repository) {
        this.repository = repository;
    }
    public Cycle AddCycle(Cycle cycle) {
        return repository.save(cycle);
    }
    public List<Cycle> getCycles() {
        return repository.findAll();
    }
    public Cycle getById(UUID id){
        return repository.findById(id).get();
    }
    public Cycle update(UUID id,Cycle cycle){
        repository.findById(id).map(c ->{
            c.setNom(cycle.getNom());
            c.setDescription(cycle.getDescription());
            return repository.save(c);
        });
        return cycle;
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}