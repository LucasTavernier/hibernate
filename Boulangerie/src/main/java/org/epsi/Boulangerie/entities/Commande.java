package org.epsi.Boulangerie.entities;

import javax.persistence.*;
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

    @Id
    @Column(name = "COMMANDE_ID")
    public int getId() {
        return id;
    }

    @Column(name = "COMMANDE_DATE", length = 20, nullable = false)
    @Temporal(TemporalType.DATE)
    public LocalDate getDate() {
        return date;
    }

    @Column(name = "COMMANDE_HEURE", length = 20, nullable = false)
    @Temporal(TemporalType.TIME)
    public LocalTime getHeure() {
        return heure;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRDT_ID")
    public Produit getProduit() {
        return produit;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLNT_ID")
    public Client getClient() {
        return client;
    }
}
