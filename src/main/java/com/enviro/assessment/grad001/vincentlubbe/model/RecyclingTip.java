package com.enviro.assessment.grad001.vincentlubbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class RecyclingTip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tip name is required")
    @Size(min = 2, max = 50, message = "Tip name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Tip description is required")
    @Size(min = 2, max = 255, message = "Tip description must be between 2 and 255 characters")
    private String description;

    public RecyclingTip() {
    }

    public RecyclingTip(String description, String name, Long id) {
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public RecyclingTip(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RecyclingTip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
