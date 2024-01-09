package org.example;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "marque")
    private String marque;

    @Column(name = "reference")
    private String reference;

    @Column(name = "date_achat")
    private Date dateAchat;

    @Column(name = "prix")
    private double prix;

    @Column(name = "stock")
    private int stock;

    public void setMarque(String marque1) {
    }

    public void setReference(String ref1) {
    }

    public void setDateAchat(Date date) {
    }

    public void setPrix(double v) {
    }

    public void setStock(int i) {
    }

    public void setId(int i) {
    }

    // Getters and setters
}
