package com.vetrix.GI_ACADEMY.cycle;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@Tag(name = "Cycle")
@CrossOrigin("*")
public class CycleController {
    private final CycleService service;

    public CycleController(CycleService service) {
        this.service = service;
    }
    @PostMapping(path = "/cycle/add")
    public Cycle add(@RequestBody Cycle cycle) {
        return service.AddCycle(cycle);
    }
    @GetMapping(path = "/unsecure/cycle")
    public List<Cycle> getAll() {
        return service.getCycles();
    }
    @GetMapping(path = "/unsecure/cycle/{id}")
    public Cycle getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @PutMapping(path = "/cycle/update/{id}")
    public Cycle update(@PathVariable UUID id, @RequestBody Cycle cycle){
        return service.update(id, cycle);
    }
    @DeleteMapping(path = "/cycle/delete/{id}")
    public String delete(@PathVariable UUID id){
        service.delete(id);
        return "success";
    }
}