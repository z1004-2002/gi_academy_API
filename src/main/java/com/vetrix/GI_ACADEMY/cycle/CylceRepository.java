package com.vetrix.GI_ACADEMY.cycle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CylceRepository extends JpaRepository<Cycle, UUID> {
}
