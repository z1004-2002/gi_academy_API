package com.vetrix.GI_ACADEMY.compte;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Tag(name = "Compte")
@CrossOrigin("*")
public class CompteController {
    private final CompteService service;

    public CompteController(CompteService service) {
        this.service = service;
    }
    @PostMapping(path = "/enseignant/create")
    public Compte createEnseignant(@RequestBody Compte compte){
        compte.setRole(Role.ENSEIGNANT);
        return service.createCompte(compte);
    }
    @PostMapping(path = "/student/create")
    public Compte createStudent(@RequestBody Compte compte){
        compte.setRole(Role.ETUDIANT);
        return service.createCompte(compte);
    }
    @GetMapping(path = "/unsecure/enseignant")
    public List<Compte> getAll(){
        return service.getAllEnseignant();
    }

    @GetMapping(path = "/unsecure/enseignant/{id}")
    public Compte getEnseignant(@PathVariable UUID id){
        return service.getEnseignantById(id);
    }

    @PutMapping(path = "/compte/update-info/{id}")
    public Compte update(@PathVariable UUID id, @RequestBody Compte compte){
        return service.updateUser(id, compte);
    }

    @PutMapping(path = "/compte/update-password/{id}")
    public String updatePassword(@PathVariable UUID id,@RequestBody Compte compte){
        service.modifiesPassword(id, compte);
        return "success";
    }
}
