package com.enviro.assessment.grad001.vincentlubbe.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class RecyclingTip extends BaseWaste {

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

    public RecyclingTip(String tip) {
        this.tip = tip;
    }

    public RecyclingTip(Long id, String name, String description, String tip) {
        super(id, name, description);
        this.tip = tip;
    }

    public RecyclingTip(String name, String description, String tip) {
        super(name, description);
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "RecyclingTip{" +
                "tip='" + tip + '\'' +
                '}';
    }
}
