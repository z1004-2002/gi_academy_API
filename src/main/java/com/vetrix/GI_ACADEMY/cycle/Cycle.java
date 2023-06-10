package com.vetrix.GI_ACADEMY.cycle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vetrix.GI_ACADEMY.niveau.Niveau;
import com.vetrix.GI_ACADEMY.sous_systeme.SousSysteme;
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
@Table(name = "cycle")
public class Cycle {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String nom;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sous_systeme_id", nullable = false)
    private SousSysteme sousSysteme;
    @JsonIgnore
    @OneToMany(
            mappedBy = "cycle",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Niveau> niveaux;
}
