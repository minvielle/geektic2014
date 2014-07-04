package com.ninja_squad.geektic.dao;

import java.util.List;

import com.ninja_squad.geektic.metier.Geek;

public interface IGeekDAO {

	public List<Geek> recupereGeeks(String sexe, int interet);
	
	public Geek recupereUnGeek(int id);
}
