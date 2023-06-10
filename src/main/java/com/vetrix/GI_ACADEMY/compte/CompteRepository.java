package com.vetrix.GI_ACADEMY.compte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompteRepository extends JpaRepository<Compte, UUID> {
    Compte findByEmail(String email);
}
