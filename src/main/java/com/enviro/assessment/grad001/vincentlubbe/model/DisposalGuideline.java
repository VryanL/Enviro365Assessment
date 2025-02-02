package com.enviro.assessment.grad001.vincentlubbe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Guideline name is required")
    @Size(min = 2, max = 50, message = "Guideline name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Disposal guideline is required")
    @Size(min = 2, max = 255, message = "Disposal guideline must be between 2 and 255 characters")
    private String description;

    public DisposalGuideline() {
    }

    public DisposalGuideline(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public DisposalGuideline(String name, String description) {
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
        return "DisposalGuideline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
