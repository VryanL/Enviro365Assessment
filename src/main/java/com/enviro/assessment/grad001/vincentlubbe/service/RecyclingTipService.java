package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.vincentlubbe.model.RecyclingTip;
import com.enviro.assessment.grad001.vincentlubbe.repository.RecyclingTipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecyclingTipService extends BaseWasteService<RecyclingTip, Long> {
    private final RecyclingTipRepository tipRepository;

    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        super(recyclingTipRepository);
        this.tipRepository = recyclingTipRepository;
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

    @Override
    public RecyclingTip getByName(String name) {
        return tipRepository.findByName(name).orElseThrow(
                ()-> new ResourceNotFoundException("No Recycling Tip found with name: " + name));
    }

    @Override
    public List<RecyclingTip> getByNameContaining(String name) {
        return tipRepository.findByNameContaining(name);
    }
}
