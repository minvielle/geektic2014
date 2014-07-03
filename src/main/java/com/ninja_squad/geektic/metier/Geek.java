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
}
