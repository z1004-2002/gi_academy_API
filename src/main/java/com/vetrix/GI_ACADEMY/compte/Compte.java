package com.vetrix.GI_ACADEMY.compte;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "compte")
@ToString
public class Compte {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String adresse;
    private String password;
    private UUID niveau;
    private Role role;


    public Compte(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
