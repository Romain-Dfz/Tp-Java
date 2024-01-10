package org.example;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contenu")
    private String contenu;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_commentaire")
    private Date dateCommentaire;

    @Column(name = "note")
    private int note;

    // getters and setters
}
