package com.vetrix.GI_ACADEMY.sous_systeme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SousRepository extends JpaRepository<SousSysteme, UUID> {
}
