package com.enviro.assessment.grad001.vincentlubbe.controller;

import com.enviro.assessment.grad001.vincentlubbe.model.DisposalGuideline;
import com.enviro.assessment.grad001.vincentlubbe.service.DisposalGuidelineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Defines a RESTful controller that handles HTTP requests.
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController extends BaseWasteController<DisposalGuideline, Long> {

    public DisposalGuidelineController(DisposalGuidelineService service) {
        super(service);
    }

}
