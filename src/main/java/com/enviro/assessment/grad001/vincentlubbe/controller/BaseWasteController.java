package com.enviro.assessment.grad001.vincentlubbe.controller;

import com.enviro.assessment.grad001.vincentlubbe.model.BaseWaste;
import com.enviro.assessment.grad001.vincentlubbe.service.BaseWasteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Base controller for waste object
//"/api/{entity}" calls for Create and Read
//"/api/{entity}/{id}" calls for Read, Update, delete
//"/api/{entity}/name/{name} calls for Read Distinct name
//"/api/{entity}/name-contain/{name} calls for Read name that contains {name}
public abstract class BaseWasteController<T extends BaseWaste, ID> {

    private final BaseWasteService<T, ID> service;

    protected BaseWasteController(BaseWasteService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<T> getByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping("/name-containing/{name}")
    public ResponseEntity<List<T>> getByNameContaining(@PathVariable String name) {
        return ResponseEntity.ok(service.getByNameContaining(name));
    }

    @PostMapping
    public ResponseEntity<T> save(@Valid @RequestBody T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T>  update(@Valid @RequestBody T entity, @PathVariable ID id) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<T>  patch(@PathVariable ID id, @RequestBody Map<String, Object> entityMap) {
        return ResponseEntity.ok(service.patch(id, entityMap));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
