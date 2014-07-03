package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.metier.Geek;

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekService {

	GeekDAO dao;
	
	@Autowired
	public GeekService(GeekDAO d) {
		this.dao = d;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{sexe}/{interet}")
    public List<Geek> recupereGeeks(@PathVariable("sexe") String sexe, @PathVariable("interet") String interet) {
        return this.dao.recupereGeeks(sexe, interet);
    }
}
