package com.vetrix.GI_ACADEMY.lecon;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Tag(name = "Leçon")
@CrossOrigin("*")
public class LeconController {
    private final LeconService service;

    public LeconController(LeconService service) {
        this.service = service;
    }
    @PostMapping(path = "/lecon/add")
    public Lecon add(@RequestBody Lecon lecon){
        return service.add(lecon);
    }
    @GetMapping(path = "/unsecure/lecon")
    public List<Lecon> getAll(){
        return service.getAll();
    }
    @GetMapping(path = "/unsecure/lecon/{id}")
    public Lecon getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @PutMapping(path = "/lecon/update/{id}")
    public Lecon update(@PathVariable UUID id,@RequestBody Lecon lecon){
        return service.update(id, lecon);
    }
    @DeleteMapping(path = "/lecon/delete/{id}")
    public String delete(@PathVariable UUID id){
        service.delete(id);
        return "success";
    }
}
