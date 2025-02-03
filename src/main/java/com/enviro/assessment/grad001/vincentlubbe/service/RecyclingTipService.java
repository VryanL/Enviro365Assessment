package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.model.RecyclingTip;
import com.enviro.assessment.grad001.vincentlubbe.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RecyclingTipService extends BaseService<RecyclingTip, Long> {

    @Autowired
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        super(recyclingTipRepository);
    }

    @Override
    public RecyclingTip update(Long id, RecyclingTip recyclingTip) {
        RecyclingTip oldRecyclingTip = getById(id);
        oldRecyclingTip.setName(recyclingTip.getName());
        oldRecyclingTip.setDescription(recyclingTip.getDescription());
        oldRecyclingTip.setTip(recyclingTip.getTip());
        return save(oldRecyclingTip);
    }

    @Override
    public RecyclingTip patch(Long id, Map<String, Object> recyclingTipMap) {
        RecyclingTip existingRecyclingTip = getById(id);

        recyclingTipMap.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingRecyclingTip.setName((String) value);
                    break;
                case "description":
                    existingRecyclingTip.setDescription((String) value);
                    break;
                case "tip":
                    existingRecyclingTip.setTip((String) value);

            }
        });
        return save(existingRecyclingTip);
    }
}
