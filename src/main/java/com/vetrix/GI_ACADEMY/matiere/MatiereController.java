package com.vetrix.GI_ACADEMY.matiere;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Tag(name = "Matiere")
@CrossOrigin("*")
public class MatiereController {
    private final MatiereService service;
    public MatiereController(MatiereService service) {
        this.service = service;
    }
    @PostMapping(path = "/matiere/add")
    public Matiere add(@RequestBody Matiere matiere){
        return service.add(matiere);
    }
    @GetMapping(path = "/unsecure/matiere/{id}")
    public Matiere getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @GetMapping(path = "/unsecure/matiere")
    public List<Matiere> getAll(){
        return service.getAll();
    }
    @PutMapping(path = "/matiere/update/{id}")
    public Matiere uptade(@PathVariable UUID id,@RequestBody Matiere matiere){
        return service.update(id, matiere);
    }
    @DeleteMapping("/matiere/delete/{id}")
    public String delete(@PathVariable UUID id){
        service.delete(id);
        return "success";
    }
    @GetMapping(path = "/matiere/enseignant/{id}")
    public List<Matiere> getMatiereByIdCompte(@PathVariable UUID id){
        return service.getMatiereEnseignant(id);
    }
}
