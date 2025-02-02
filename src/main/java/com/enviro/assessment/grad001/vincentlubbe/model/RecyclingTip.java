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

    @NotBlank(message = "Recycling tip is required")
    @Size(min = 2, max = 255, message = "Tip must be between 2 and 255 characters")
    private String tip;

    public RecyclingTip() {
    }

    public RecyclingTip(Long id, String name, String tip)  {
        this.id = id;
        this.name = name;
        this.tip = tip;
    }

    public RecyclingTip(String name, String tip) {
        this.name = name;
        this.tip = tip;
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "RecyclingTip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }
}
