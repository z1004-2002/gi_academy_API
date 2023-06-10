package com.vetrix.GI_ACADEMY.matiere;

import com.vetrix.GI_ACADEMY.compte.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MatiereService {
    private final MatiereRepository repository;
    private final CompteRepository compteRepository;

    public MatiereService(MatiereRepository repository, CompteRepository compteRepository) {
        this.repository = repository;
        this.compteRepository = compteRepository;
    }
    public Matiere add(Matiere matiere){
        return repository.save(matiere);
    }
    public List<Matiere> getAll(){
        return repository.findAll();
    }
    public Matiere getById(UUID id){
        return repository.findById(id).get();
    }
    public Matiere update(UUID id,Matiere matiere){
        repository.findById(id).map(mat -> {
            mat.setNom(matiere.getNom());
            mat.setDescription(matiere.getDescription());
            mat.setCompte(matiere.getCompte());
            return repository.save(mat);
        });
        return matiere;
    }
    public List<Matiere> getMatiereEnseignant(UUID idCompte){
        return repository.getMatiereByCompte(compteRepository.findById(idCompte).get());
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}