package org.epsi.Boulangerie.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="CLIENT",uniqueConstraints = {@UniqueConstraint(columnNames = { "id" })})
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

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public int getId() {
		return id;
	}
	
	

}
