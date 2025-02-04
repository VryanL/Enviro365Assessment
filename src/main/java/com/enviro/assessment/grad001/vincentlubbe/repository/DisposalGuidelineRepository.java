package com.enviro.assessment.grad001.vincentlubbe.repository;

import com.enviro.assessment.grad001.vincentlubbe.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//JpaRepository provides built-in CRUD operations.
@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuideline, Long> {

    Optional<DisposalGuideline> findByName(String name);

    List<DisposalGuideline> findByNameContaining(String name);
}
