package com.vetrix.GI_ACADEMY.lecon;


import com.vetrix.GI_ACADEMY.chapitre.Chapitre;
import com.vetrix.GI_ACADEMY.cycle.Cycle;
import com.vetrix.GI_ACADEMY.matiere.Matiere;
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
@Table(name = "lecon")
public class Lecon {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String nom;
    private String description;
    @ManyToOne
    @JoinColumn(name = "chapitre_id", nullable = false)
    private Chapitre chapitre;
}