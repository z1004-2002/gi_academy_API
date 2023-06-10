package com.vetrix.GI_ACADEMY.matiere;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vetrix.GI_ACADEMY.chapitre.Chapitre;
import com.vetrix.GI_ACADEMY.compte.Compte;
import com.vetrix.GI_ACADEMY.niveau.Niveau;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String nom;
    private String description;
    @ManyToOne
    @JoinColumn(name = "niveau_id", nullable = false)
    private Niveau niveau;
    @JsonIgnore
    @OneToMany(mappedBy = "matiere",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Chapitre> chapitres;
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;
}
