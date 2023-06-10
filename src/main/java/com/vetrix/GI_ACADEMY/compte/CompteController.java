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
    @PostMapping(path = "/unsecure/enseignant/create")
    public Compte createEnseignant(@RequestBody Compte compte){
        compte.setRole(Role.ENSEIGNANT);
        return service.createCompte(compte);
    }

    @PostMapping(path = "/unsecure/student/create/{idNiveau}")
    public Compte createStudent(@RequestBody Compte compte,@PathVariable UUID id){
        compte.setRole(Role.ETUDIANT);
        compte.setNiveau(id);
        return service.createCompte(compte);
    }

    @GetMapping(path = "/unsecure/enseignant")
    public List<Compte> getAll(){
        return service.getAllEnseignant();
    }

    @GetMapping(path = "/unsecure/student")
    public List<Compte> getAllStudent(){
        return service.getAllStudent();
    }
    @GetMapping(path = "/unsecure/admin")
    public Compte getAdmin(){
        return service.getAdmin();
    }

    @GetMapping(path = "/unsecure/compte/{id}")
    public Compte getCompte(@PathVariable UUID id){
        return service.getCompteById(id);
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
