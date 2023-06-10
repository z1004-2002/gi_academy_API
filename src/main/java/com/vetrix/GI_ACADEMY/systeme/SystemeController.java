package com.vetrix.GI_ACADEMY.systeme;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Tag(name = "Systeme")
@RequestMapping
@CrossOrigin("*")
public class SystemeController {
    private final SystemeService service;

    public SystemeController(SystemeService service) {
        this.service = service;
    }
    @PostMapping(path = "/systeme/add")
    public Systeme add(@RequestBody Systeme systeme){
        return service.addSysteme(systeme);
    }
    @GetMapping(path = "/unsecure/systeme")
    public List<Systeme> getAll() {
        return service.getAllSysteme();
    }
    @GetMapping(path = "/unsecure/systeme/{id}")
    public Systeme get(@PathVariable UUID id){
        return service.findById(id);
    }
    @PutMapping(path = "/systeme/update/{id}")
    public Systeme update(@PathVariable UUID id,@RequestBody Systeme systeme){
        return service.update(id,systeme);
    }
    @DeleteMapping(path = "/systeme/delete/{id}")
    public String delete(@PathVariable UUID id){
        service.delete(id);
        return "success";
    }
}
