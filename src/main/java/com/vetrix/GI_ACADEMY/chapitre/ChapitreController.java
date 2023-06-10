package com.vetrix.GI_ACADEMY.chapitre;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Tag(name = "Chapitre")
@CrossOrigin("*")
public class ChapitreController {
    private final ChapitreService service;

    public ChapitreController(ChapitreService service) {
        this.service = service;
    }
    @PostMapping(path = "/chapitre/add")
    public Chapitre add(@RequestBody Chapitre chapitre){
        return service.add(chapitre);
    }
    @GetMapping(path = "/unsecure/chapitre")
    public List<Chapitre> getAll(){
        return service.getAll();
    }
    @GetMapping(path = "/unsecure/chapitre/{id}")
    public Chapitre getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @PutMapping(path = "/chapitre/update/{id}")
    public Chapitre update(@PathVariable UUID id,@RequestBody Chapitre chapitre){
        return service.update(id, chapitre);
    }
    @DeleteMapping(path = "/chapitre/delete/{id}")
    public String delete(@PathVariable UUID id){
        service.delete(id);
        return "success";
    }
}
