package com.enviro.assessment.grad001.vincentlubbe.controller;

import com.enviro.assessment.grad001.vincentlubbe.model.WasteCategory;
import com.enviro.assessment.grad001.vincentlubbe.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Defines a RESTful controller that handles HTTP requests.
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {
    private final WasteCategoryService service;

    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.service = wasteCategoryService;
    }

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(service.saveCategory(wasteCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(service.updateCategory(id, wasteCategory));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WasteCategory> patchCategory(@PathVariable Long id, @Valid @RequestBody Map<String, Object> wasteCategory) {
        WasteCategory existingCategory = service.getCategoryById(id);

        wasteCategory.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingCategory.setName((String) value);
                    break;
                case "description":
                    existingCategory.setDescription((String) value);
                    break;
            }

        });

        return ResponseEntity.ok(service.updateCategory(id, existingCategory));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }

}
