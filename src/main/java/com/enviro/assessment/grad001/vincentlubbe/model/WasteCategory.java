package com.enviro.assessment.grad001.vincentlubbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category name is required")
    @Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Waste category is required")
    @Size(min = 2, max = 255, message = "Waste category must be between 2 and 255 characters")
    private String category;

    public WasteCategory() {
    }

    public WasteCategory(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public WasteCategory(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
