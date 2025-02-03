package com.enviro.assessment.grad001.vincentlubbe.service;


import com.enviro.assessment.grad001.vincentlubbe.model.DisposalGuideline;
import com.enviro.assessment.grad001.vincentlubbe.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

//Marks this class as a service, separating business logic from controllers
@Service
public class DisposalGuidelineService extends BaseService<DisposalGuideline, Long> {

    @Autowired
    public DisposalGuidelineService(DisposalGuidelineRepository disposalGuidelineRepository) {
        super(disposalGuidelineRepository);
    }

    @Override
    public DisposalGuideline update(Long id, DisposalGuideline disposalGuideline) {
        DisposalGuideline oldDisposalGuideline = getById(id);
        oldDisposalGuideline.setName(disposalGuideline.getName());
        oldDisposalGuideline.setDescription(disposalGuideline.getDescription());
        oldDisposalGuideline.setGuideline(disposalGuideline.getGuideline());
        return save(oldDisposalGuideline);
    }

    @Override
    public DisposalGuideline patch(Long id, Map<String, Object> disposalGuidelineMap) {
        DisposalGuideline existingDisposalGuideline = getById(id);

        disposalGuidelineMap.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingDisposalGuideline.setName((String) value);
                    break;
                case "description":
                    existingDisposalGuideline.setDescription((String) value);
                    break;
                case "guideline":
                    existingDisposalGuideline.setGuideline((String) value);

            }
        });
        return save(existingDisposalGuideline);
    }
}
