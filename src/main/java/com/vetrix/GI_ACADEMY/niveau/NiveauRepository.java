package com.vetrix.GI_ACADEMY.niveau;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, UUID> {
}
