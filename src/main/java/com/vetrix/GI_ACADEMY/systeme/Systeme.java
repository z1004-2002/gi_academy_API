package com.vetrix.GI_ACADEMY.systeme;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "systeme")
public class Systeme {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String nom;
    private String description;
    @JsonIgnore
    @OneToMany(
            mappedBy = "systeme",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<SousSysteme> systemes;
}
