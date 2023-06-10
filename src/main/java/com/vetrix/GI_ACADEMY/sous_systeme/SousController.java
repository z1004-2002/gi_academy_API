package com.vetrix.GI_ACADEMY.sous_systeme;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Tag(name = "Sous Systeme")
@CrossOrigin("*")
public class SousController {
    private final SousService service;

    @Autowired
    public SousController(SousService service) {
        this.service = service;
    }
    @PostMapping(path = "/sous-systeme/add")
    public SousSysteme addSousSystem(@RequestBody SousSysteme sousSysteme){
        return service.addSous(sousSysteme);
    }
    @GetMapping(path = "/unsecure/sous-systeme")
    public List<SousSysteme> getAllSousSysteme(){
        return service.getAll();
    }
    @GetMapping(path = "/unsecure/sous-systeme/{id}")
    public SousSysteme getSousSystemById(@PathVariable UUID id){
        return service.getById(id);
    }
    @PutMapping(path = "/sous-systeme/update/{id}")
    public SousSysteme updateSousSystem(@PathVariable UUID id,@RequestBody SousSysteme sousSysteme){
        return service.update(id,sousSysteme);
    }
    @DeleteMapping(path = "/sous-systemedelete/{id}")
    public String deleteSousSystem(@PathVariable UUID id){
        service.delete(id);
        return "success";
    }
}
