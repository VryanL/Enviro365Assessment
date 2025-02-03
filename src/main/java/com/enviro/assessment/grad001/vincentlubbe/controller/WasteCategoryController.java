package com.enviro.assessment.grad001.vincentlubbe.controller;

import com.enviro.assessment.grad001.vincentlubbe.model.WasteCategory;
import com.enviro.assessment.grad001.vincentlubbe.service.WasteCategoryService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController extends BaseController<WasteCategory, Long> {
    public WasteCategoryController(WasteCategoryService service) {
        super(service);
    }
}
