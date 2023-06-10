package com.vetrix.GI_ACADEMY.systeme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SystemeRepository extends JpaRepository<Systeme, UUID> {
}
