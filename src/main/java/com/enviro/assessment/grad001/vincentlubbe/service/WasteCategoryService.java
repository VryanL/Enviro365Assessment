package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.vincentlubbe.model.WasteCategory;
import com.enviro.assessment.grad001.vincentlubbe.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class WasteCategoryService {
    private final WasteCategoryRepository repository;

    @Autowired
    public WasteCategoryService(WasteCategoryRepository repository) {
        this.repository = repository;
    }

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public WasteCategory getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Waste category not found with id: " + id));
    }

    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    public WasteCategory updateCategory(Long id, WasteCategory category) {
        WasteCategory existingCategory = getCategoryById(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return repository.save(existingCategory);

    }

    public WasteCategory patchCategory(Long id, Map<String, Object> category) {
        WasteCategory existingCategory = getCategoryById(id);

        category.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingCategory.setName((String) value);
                    break;
                case "description":
                    existingCategory.setDescription((String) value);
                    break;
            }
        });
        return repository.save(existingCategory);
    }

    public void deleteCategory(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Waste category not found with id: " + id);
        }
        repository.deleteById(id);
    }
}