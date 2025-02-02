package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.vincentlubbe.model.RecyclingTip;
import com.enviro.assessment.grad001.vincentlubbe.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        existingRecyclingTip.setTip(recyclingTip.getTip());
        return repository.save(existingRecyclingTip);
    }

    public RecyclingTip patchTip(Long id, Map<String, Object> patch) {
        RecyclingTip existingRecyclingTip = getRecyclingTipById(id);

        patch.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingRecyclingTip.setName(value.toString());
                    break;
                case "tip":
                    existingRecyclingTip.setTip(value.toString());
                    break;
            }
        });
        return repository.save(existingRecyclingTip);
    }

    public void deleteTip(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("No tip found with id: " + id);
        }
        repository.deleteById(id);
    }
}
