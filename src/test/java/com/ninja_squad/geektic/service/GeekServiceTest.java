package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ninja_squad.geektic.config.AppConfig;
import com.ninja_squad.geektic.dao.IGeekDAO;
import com.ninja_squad.geektic.dao.IInteretDAO;
import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.Interet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class })
public class GeekServiceTest {

	private IGeekDAO daoG;
	private IInteretDAO daoI;
	private GeekService serv;
	
	@Before
    public void prepare() {
            daoG = mock(IGeekDAO.class);
            daoI = mock(IInteretDAO.class);
            serv = new GeekService(daoG, daoI);
	}
	
	@Test
	public void testRecupereGeek() {
		ArrayList<Geek> retourDAO = new ArrayList<>();
		ArrayList<Interet> interets = new ArrayList<>();
		
		Geek g = new Geek();
		Interet i = new Interet();
		
		i.setNom("JAVA");
		i.setNum(0);
		
		interets.add(i);
		
		g.setNom("Minvielle");
		g.setSexe("M");
		g.setInterets(interets);
		
        retourDAO.add(g);
        
        i.setNom("JAVA");
        i.setNum(0);
		
		interets.add(i);
		
		g.setNom("Teste");
		g.setSexe("M");
		g.setInterets(interets);
		
        retourDAO.add(g);
        
        when(daoG.recupereGeeks("M", 0)).thenReturn(retourDAO);
        
        List<Geek> retourService = serv.recupereGeeks("M", 0);
        
        assertEquals(2, retourService.size());
	}
	
	@Test
	public void testRecupereUnGeek() {
		Interet i = new Interet();
		i.setNom("JAVA");
		i.setNum(0);
		
		ArrayList<Interet> interets = new ArrayList<>();
		interets.add(i);
		
		Geek g = new Geek();
		g.setNom("Minvielle");
		g.setNum(0);
		g.setInterets(interets);
		
		when(daoG.recupereUnGeek(0)).thenReturn(g);
		
		Geek retourService = serv.recupereUnGeek(0);
		
		assertEquals("Minvielle", retourService.getNom());
	}
	
	@Test
	public void testListeInteret() {
		ArrayList<Interet> retourDAO = new ArrayList<>();
		Interet i = new Interet();
		
		i.setNom("JAVA");
		i.setNum(0);
		retourDAO.add(i);
		
		i.setNom("JEE");
		i.setNum(1);
		retourDAO.add(i);
		
		when(daoI.listeInterets()).thenReturn(retourDAO);
		
		List<Interet> retourService = serv.listeInterets();
		
		assertEquals(2, retourService.size());
	}
}
