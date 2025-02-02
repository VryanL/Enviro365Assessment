package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.vincentlubbe.model.RecyclingTip;
import com.enviro.assessment.grad001.vincentlubbe.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {
    private final RecyclingTipRepository repository;

    @Autowired
    public RecyclingTipService(RecyclingTipRepository repository) {
        this.repository = repository;
    }

    public List<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    public RecyclingTip getRecyclingTipById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No tip found with id: " + id));
    }

    public RecyclingTip saveTip(RecyclingTip recyclingTip) {
        return repository.save(recyclingTip);
    }

    public RecyclingTip updateTip(Long id, RecyclingTip recyclingTip) {
        RecyclingTip existingRecyclingTip = getRecyclingTipById(id);
        existingRecyclingTip.setName(recyclingTip.getName());
        existingRecyclingTip.setDescription(recyclingTip.getDescription());
        return repository.save(existingRecyclingTip);
    }

    public void deleteTip(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("No tip found with id: " + id);
        }
        repository.deleteById(id);
    }
}
