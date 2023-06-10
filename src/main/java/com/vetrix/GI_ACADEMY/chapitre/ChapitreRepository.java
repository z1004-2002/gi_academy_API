package com.vetrix.GI_ACADEMY.chapitre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChapitreRepository extends JpaRepository<Chapitre, UUID> {

}
