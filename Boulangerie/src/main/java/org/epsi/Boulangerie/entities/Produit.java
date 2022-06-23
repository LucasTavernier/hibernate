package org.epsi.Boulangerie.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public double getPrix() {
        return prix;
    }
}
