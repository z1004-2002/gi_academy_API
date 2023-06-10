package com.vetrix.GI_ACADEMY.file;

import com.vetrix.GI_ACADEMY.lecon.Lecon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String type;
    private String downloadUri;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "lecon_id")
    private Lecon lecon;

    public File(String name, String type, String downloadUri, Lecon lecon) {
        this.name = name;
        this.type = type;
        this.downloadUri = downloadUri;
        this.lecon = lecon;
    }
}
