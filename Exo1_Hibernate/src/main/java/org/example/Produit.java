package org.example;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_achat")
    private Date dateAchat;

    @Column(name = "marque")
    private String marque;

    @Column(name = "prix")
    private double prix;

    @Column(name = "reference")
    private String reference;

    @Column(name = "stock")
    private int stock;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "produit_id")
    private Set<Image> images = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "produit_id")
    private Set<Commentaire> commentaires = new HashSet<>();

    public <E> List<E> getImages() {
        return null;
    }

    public <E> List<E> getCommentaires() {
        return null;
    }

    // getters and setters
}
