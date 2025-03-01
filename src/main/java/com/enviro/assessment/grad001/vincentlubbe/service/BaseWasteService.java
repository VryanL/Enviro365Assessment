package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.vincentlubbe.model.BaseWaste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

//Abstract class for service for common function calls
//update, patch, getByName and getByNameContaining are abstract
public abstract class BaseWasteService<T extends BaseWaste, ID> {

    protected final JpaRepository<T, ID> repository;

    protected BaseWasteService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T getById(ID id) {
        return repository.findById(id).orElseThrow(
                 () -> new ResourceNotFoundException("No record found with id: " + id));
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        else {
            throw new ResourceNotFoundException("No record found with id: " + id);
        }
    }

    public abstract T update(ID id, T entity);

    public abstract T patch(ID id, Map<String, Object> theMap);

    public abstract T getByName(String name);

    public abstract List<T> getByNameContaining(String name);
}
