package com.enviro.assessment.grad001.vincentlubbe.controller;

import com.enviro.assessment.grad001.vincentlubbe.model.RecyclingTip;
import com.enviro.assessment.grad001.vincentlubbe.service.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipsContoller {
    private final RecyclingTipService service;

    public RecyclingTipsContoller(RecyclingTipService recyclingTipService) {
        this.service = recyclingTipService;
    }

    @GetMapping
    public List<RecyclingTip> getAllRecyclingTips() {
        return service.getAllTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRecyclingTipById(id));
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@Valid @RequestBody RecyclingTip recyclingTip) {
        return ResponseEntity.ok(service.saveTip(recyclingTip));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTip recyclingTip) {
        return ResponseEntity.ok(service.updateTip(id, recyclingTip));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RecyclingTip> patchRecyclingTip(@PathVariable Long id, @RequestBody Map<String, Objects> recyclingTip) {
        RecyclingTip existingRecyclingTip = service.getRecyclingTipById(id);

        recyclingTip.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingRecyclingTip.setName(value.toString());
                    break;
                case "description":
                    existingRecyclingTip.setDescription(value.toString());
                    break;
            }
        });

        return ResponseEntity.ok(service.updateTip(id, existingRecyclingTip));
    }

    @DeleteMapping("/{id}")
    public void deleteRecyclingTipById(@PathVariable Long id) {
        service.deleteTip(id);
    }
}
