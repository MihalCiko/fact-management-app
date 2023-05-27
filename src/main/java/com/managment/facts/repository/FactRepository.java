package com.managment.facts.repository;

import com.managment.facts.entity.Fact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface FactRepository extends JpaRepository<Fact, UUID> {
    List<Fact> findByFact(String fact);
}
