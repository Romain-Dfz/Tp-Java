package org.example;

import javax.persistence.*;
import java.util.Date;

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

}
