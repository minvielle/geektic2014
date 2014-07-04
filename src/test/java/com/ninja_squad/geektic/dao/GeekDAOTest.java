package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.geektic.metier.Geek;


public class GeekDAOTest extends BaseDaoTest{
	
	@Autowired
	private GeekDAO dao;
	
	@Test
	public void testRecupereGeek() {
		List<Geek> l = dao.recupereGeeks("F", 0);
		
		assertEquals("Azerty", l.get(0).getNom());
		assertEquals("Princesse", l.get(1).getNom());
	}
	
	@Test
	public void testRecupereUnGeek() {
		Geek g = dao.recupereUnGeek(0);
		
		assertEquals("Minvielle", g.getNom());
	}
}
