package com.enviro.assessment.grad001.vincentlubbe.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class RecyclingTip extends WasteInfo{

    @NotBlank(message = "Tip is required")
    @Size(min = 2, max = 255, message = "Tip must be between 2 and 255 charters")
    private String tip;

    public RecyclingTip() {

    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "RecyclingTip{" +
                "tip='" + tip + '\'' +
                '}';
    }
}
