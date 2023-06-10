package com.vetrix.GI_ACADEMY.sous_systeme;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vetrix.GI_ACADEMY.cycle.Cycle;
import com.vetrix.GI_ACADEMY.systeme.Systeme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sous_systeme")
public class SousSysteme {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String nom;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "systeme_id",nullable = false)
    private Systeme systeme;
    @JsonIgnore
    @OneToMany(
            mappedBy = "sousSysteme",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Cycle> cycles;
}
