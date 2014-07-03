package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.Interet;

@Repository
public class InteretDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Interet> listeInterets() {
		String jpql = "select i from Interet i";
		TypedQuery<Interet> query = em.createQuery(jpql,Interet.class);
		return query.getResultList();
	}
}
