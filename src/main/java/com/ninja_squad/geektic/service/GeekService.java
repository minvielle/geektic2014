package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.IGeekDAO;
import com.ninja_squad.geektic.dao.IInteretDAO;
import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.Interet;

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekService {

	IGeekDAO daoG;
	IInteretDAO daoI;
	
	@Autowired
	public GeekService(IGeekDAO g, IInteretDAO i) {
		this.daoG = g;
		this.daoI = i;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{sexe}/{interet}")
    public List<Geek> recupereGeeks(@PathVariable("sexe") String sexe, @PathVariable("interet") int interet) {
        return this.daoG.recupereGeeks(sexe, interet);
    }
	

	@RequestMapping(method = RequestMethod.GET, value="/{num}")
	public Geek recupereUnGeek(@PathVariable("num") int num) {
		return this.daoG.recupereUnGeek(num);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/interets")
	public List<Interet> listeInterets() {
		return this.daoI.listeInterets();
	}
	
}
