package org.epsi.Boulangerie.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="COMMANDE",uniqueConstraints = {@UniqueConstraint(columnNames = { "id" })})
public class Commande {

    private int id;
    private LocalDate date;
    private LocalTime heure;
    private Produit produit;
    private Client client;

    public Commande(int id, LocalDate date, LocalTime heure, Produit produit, Client client) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.produit = produit;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public Produit getProduit() {
        return produit;
    }

    public Client getClient() {
        return client;
    }
}
