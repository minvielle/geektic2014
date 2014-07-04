package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.geektic.metier.Interet;

public class InteretDAOTest extends BaseDaoTest {

	@Autowired
	private InteretDAO dao;
	
	@Test
	public void testListeInterets() {
		List<Interet> l = dao.listeInterets();
		
		assertEquals(10, l.size());
	}
}
