package com.ninja_squad.geektic.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Interet {

	@Id
	private int num;
	
	@Column
	private String nom;
}
