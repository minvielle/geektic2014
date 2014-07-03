package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Geek {

	@Id
	private int num;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String sexe;
	
	@Column
	private int age;
	
	@Column
	private String url_gravatar;
	
	@ManyToMany
	@JoinTable(name = "Liaison_Geek_Interet",
				joinColumns = { @JoinColumn(name = "numG") },
				inverseJoinColumns = { @JoinColumn(name = "numI") })
	private List<Interet> interets;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUrl_gravatar() {
		return url_gravatar;
	}

	public void setUrl_gravatar(String url_gravatar) {
		this.url_gravatar = url_gravatar;
	}

	public List<Interet> getInterets() {
		return interets;
	}

	public void setInterets(List<Interet> interets) {
		this.interets = interets;
	}
	
}
