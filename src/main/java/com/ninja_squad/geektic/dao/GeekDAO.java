package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.Geek;

@Repository
public class GeekDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Geek> recupereGeek(String sexe, String interet) {
		String jpql = "select g from Geek g"
				+ " join Interet i"
				+ " where g.sexe = :sexe and i.nom = :interet";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		query.setParameter("interet", interet);
		
		return query.getResultList();
	}
}
