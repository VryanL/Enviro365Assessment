package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.vincentlubbe.model.DisposalGuideline;
import com.enviro.assessment.grad001.vincentlubbe.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Marks this class as a service, separating business logic from controllers
@Service
public class DisposalGuidelineService {
    private final DisposalGuidelineRepository repository;

    @Autowired
    public DisposalGuidelineService(DisposalGuidelineRepository Repository) {
        this.repository = Repository;
    }

    public List<DisposalGuideline> getAllGuidelines() {
        return repository.findAll();
    }

    public DisposalGuideline getGuidelineById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Guideline found with id: " + id));
    }

    public DisposalGuideline saveGuideline(DisposalGuideline Guideline) {
        return repository.save(Guideline);
    }

    public DisposalGuideline updateGuideline(Long id, DisposalGuideline Guideline) {
        DisposalGuideline existingGuideline = getGuidelineById(id);
        existingGuideline.setName(Guideline.getName());
        existingGuideline.setDescription(Guideline.getDescription());
        return repository.save(existingGuideline);
    }

    public void deleteGuideline(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("No Guideline found with id: " + id);
        }
        repository.deleteById(id);
    }

}
