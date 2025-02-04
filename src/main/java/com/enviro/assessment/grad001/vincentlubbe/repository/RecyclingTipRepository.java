package com.enviro.assessment.grad001.vincentlubbe.repository;

import com.enviro.assessment.grad001.vincentlubbe.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    Optional<RecyclingTip> findByName(String name);

    List<RecyclingTip> findByNameContaining(String name);
}
