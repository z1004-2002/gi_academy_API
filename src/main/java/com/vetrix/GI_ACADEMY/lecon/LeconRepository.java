package com.vetrix.GI_ACADEMY.lecon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeconRepository extends JpaRepository<Lecon, UUID> {
}
