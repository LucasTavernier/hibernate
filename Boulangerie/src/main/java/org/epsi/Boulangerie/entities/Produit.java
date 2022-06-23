package org.epsi.Boulangerie.entities;

import javax.persistence.*;

@Entity
@Table(name="PRODUIT",uniqueConstraints = {@UniqueConstraint(columnNames = { "id" })})
public class Produit {

    private int id;
    private String libelle;
    private double prix;

    public Produit(int id, String libelle, double prix) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
    }

    @Id
    @Column(name = "PRODUIT_ID")
    public int getId() {
        return id;
    }

    @Column(name = "PRODUIT_LIBELLE", length = 50, nullable = false)
    public String getLibelle() {
        return libelle;
    }

    @Column(name = "PRODUIT_PRIX", length = 6, nullable = false)
    public double getPrix() {
        return prix;
    }
}
