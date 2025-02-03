package com.enviro.assessment.grad001.vincentlubbe.controller;

import com.enviro.assessment.grad001.vincentlubbe.model.RecyclingTip;
import com.enviro.assessment.grad001.vincentlubbe.service.RecyclingTipService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipsController extends BaseController<RecyclingTip, Long> {
    public RecyclingTipsController(RecyclingTipService service) {
        super(service);
    }

}
