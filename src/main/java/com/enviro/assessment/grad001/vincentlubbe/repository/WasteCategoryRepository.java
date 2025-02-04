package com.enviro.assessment.grad001.vincentlubbe.repository;

import com.enviro.assessment.grad001.vincentlubbe.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    Optional<WasteCategory> findByName(String name);

    List<WasteCategory> findByNameContaining(String name);
}
