package org.epsi.Boulangerie.entities;

import javax.persistence.*;

@Entity
@Table(name="CLIENT",uniqueConstraints = {@UniqueConstraint(columnNames = { "CLIENT_ID" })})
public class Client {

	private int id;
	private String nom,prenom,telephone;

	public Client(int id, String nom, String prenom, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}

	public Client() {
	}

	@Id
	@Column(name = "CLIENT_ID")
	public int getId() {
		return id;
	}

	@Column(name = "CLIENT_NOM", length = 50, nullable = false)
	public String getNom() {
		return nom;
	}

	@Column(name = "CLIENT_PRENOM", length = 50, nullable = false)
	public String getPrenom() {
		return prenom;
	}

	@Column(name = "CLIENT_TELEPHONE", length = 10, nullable = false)
	public String getTelephone() {
		return telephone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return this.nom + " " + this.prenom + " (" + this.telephone + ")";
	}
}
