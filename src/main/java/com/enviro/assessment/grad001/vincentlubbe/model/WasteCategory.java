package com.enviro.assessment.grad001.vincentlubbe.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class WasteCategory extends WasteInfo {

    @NotBlank(message = "Category is required")
    @Size(min = 2, max = 255, message = "Category must be between 2 and 255 charters")
    private String category;

    public WasteCategory() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "WasteCategory{" +
                "category='" + category + '\'' +
                '}';
    }
}
