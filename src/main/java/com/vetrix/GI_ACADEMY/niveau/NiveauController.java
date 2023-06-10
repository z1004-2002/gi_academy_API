package com.vetrix.GI_ACADEMY.niveau;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Tag(name = "Niveau")
@CrossOrigin("*")
public class NiveauController {
    private final NiveauService service;

    public NiveauController(NiveauService service) {
        this.service = service;
    }
    @PostMapping(path = "/niveau/add")
    public Niveau add(@RequestBody Niveau niveau){
        return service.add(niveau);
    }
    @GetMapping(path = "/unsecure/niveau")
    public List<Niveau> getAll(){
        return service.getAll();
    }
    @GetMapping(path = "/unsecure/niveau/{id}")
    public Niveau getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @PutMapping(path = "/niveau/update/{id}")
    public Niveau update(@PathVariable UUID id, @RequestBody Niveau niveau){
        return service.update(id,niveau);
    }
    @DeleteMapping(path = "/niveau/delete/{id}")
    public String delete(@PathVariable UUID id){
        service.delete(id);
        return "success";
    }
}
