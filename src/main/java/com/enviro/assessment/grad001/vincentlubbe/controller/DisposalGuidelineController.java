package com.enviro.assessment.grad001.vincentlubbe.controller;

import com.enviro.assessment.grad001.vincentlubbe.model.DisposalGuideline;
import com.enviro.assessment.grad001.vincentlubbe.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {
    private final DisposalGuidelineService service;

    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.service = disposalGuidelineService;
    }

    @GetMapping
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return service.getAllGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getGuidelineById(id));
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@Valid @RequestBody DisposalGuideline disposalGuideline) {
        return ResponseEntity.ok(service.saveGuideline(disposalGuideline));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @Valid @RequestBody DisposalGuideline disposalGuideline) {
        return ResponseEntity.ok(service.updateGuideline(id, disposalGuideline));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DisposalGuideline> patchGuideline(@PathVariable Long id, @RequestBody Map<String, Object> disposalGuideline) {
        DisposalGuideline existingGuideline = service.getGuidelineById(id);

        disposalGuideline.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingGuideline.setName(value.toString());
                    break;
                case "description":
                    existingGuideline.setDescription(value.toString());
                    break;
            }
        });

        return ResponseEntity.ok(service.saveGuideline(existingGuideline));
    }

    @DeleteMapping("/{id}")
    public void deleteDisposalGuidelineById(@PathVariable Long id) {
        service.deleteGuideline(id);
    }

}
