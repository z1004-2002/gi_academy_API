package com.vetrix.GI_ACADEMY.matiere;

import com.vetrix.GI_ACADEMY.compte.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, UUID> {
    @Query("select m from Matiere m where m.compte = ?1")
    List<Matiere> getMatiereByCompte(Compte compte);
}
