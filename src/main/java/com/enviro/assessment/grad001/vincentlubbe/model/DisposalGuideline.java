package com.enviro.assessment.grad001.vincentlubbe.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class DisposalGuideline extends WasteInfo{

    @NotBlank(message = "Guideline is required")
    @Size(min = 2, max = 255, message = "Guideline must be between 2 and 255 charters")
    private String guideline;

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String disposalGuideline) {
        this.guideline = disposalGuideline;
    }

    public DisposalGuideline() {

    }

    @Override
    public String toString() {
        return "DisposalGuideline{" +
                "Guideline='" + guideline + '\'' +
                '}';
    }
}
