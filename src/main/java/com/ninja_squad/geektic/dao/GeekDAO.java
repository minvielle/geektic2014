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
	
	public List<Geek> recupereGeeks(String sexe, int interet) {
		String jpql = "select distinct g from Geek g"
				+ " left join fetch g.interets gi"
				+ " inner join g.interets i"
				+ " where g.sexe = :sexe and i.num = :interet";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		query.setParameter("interet", interet);
		
		return query.getResultList();
	}
	
	public Geek recupereUnGeek(int id) {
		String jpql = "select distinct g from Geek g"
				+ " left join fetch g.interets gi"
				+ " inner join g.interets i"
				+ " where g.num = :num";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		query.setParameter("num", id);
		
		return query.getSingleResult();
	}
}
