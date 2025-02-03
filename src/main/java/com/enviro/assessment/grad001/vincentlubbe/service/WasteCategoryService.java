package com.enviro.assessment.grad001.vincentlubbe.service;

import com.enviro.assessment.grad001.vincentlubbe.model.WasteCategory;
import com.enviro.assessment.grad001.vincentlubbe.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class WasteCategoryService extends BaseService<WasteCategory, Long> {

    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        super(wasteCategoryRepository);
    }

    @Override
    public WasteCategory update(Long id, WasteCategory wasteCategory) {
        WasteCategory oldWasteCategory = getById(id);
        oldWasteCategory.setName(wasteCategory.getName());
        oldWasteCategory.setDescription(wasteCategory.getDescription());
        oldWasteCategory.setCategory(wasteCategory.getCategory());
        return save(oldWasteCategory);
    }

    @Override
    public WasteCategory patch(Long id, Map<String, Object> wasteCategoryMap) {
        WasteCategory existingWasteCategory = getById(id);

        wasteCategoryMap.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingWasteCategory.setName((String) value);
                    break;
                case "description":
                    existingWasteCategory.setDescription((String) value);
                    break;
                case "category":
                    existingWasteCategory.setCategory((String) value);

            }
        });
        return save(existingWasteCategory);
    }
}