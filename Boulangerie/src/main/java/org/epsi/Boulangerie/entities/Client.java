package org.epsi.Boulangerie.entities;

import javax.persistence.*;

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

	
	

}
