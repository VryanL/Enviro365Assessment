package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

//Abstract class for service for generic function calls
public abstract class BaseService<T, ID> {

    private final JpaRepository<T, ID> repository;

    protected BaseService(JpaRepository<T, ID> repository) {
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
}
