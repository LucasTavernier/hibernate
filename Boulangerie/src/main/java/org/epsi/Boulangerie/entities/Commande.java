package org.epsi.Boulangerie.entities;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="COMMANDE",uniqueConstraints = {@UniqueConstraint(columnNames = { "COMMANDE_ID" })})
public class Commande {

    private int id;
    private Date date;
    private Date heure;
    private Produit produit;
    private Client client;

    public Commande(int id, Date date, Date heure, Produit produit, Client client) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.produit = produit;
        this.client = client;
    }

    public Commande() {
    }

    @Id
    @Column(name = "COMMANDE_ID")
    public int getId() {
        return id;
    }

    @Column(name = "COMMANDE_DATE", length = 20, nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    @Column(name = "COMMANDE_HEURE", length = 20, nullable = false)
    @Temporal(TemporalType.TIME)
    public Date getHeure() {
        return heure;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRDT_ID")
    public Produit getProduit() {
        return produit;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CLNT_ID")
    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Commande n°"+ this.id
                +" à " + heure.getHours() + "h" + heure.getMinutes()
                + " le " + date.toString()
                + " un " + produit.toString()
                + " acheté par " + client.toString();
    }
}
