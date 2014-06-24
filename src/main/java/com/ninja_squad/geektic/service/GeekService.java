package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.entity.Geek;

@RestController
@Transactional
@RequestMapping("/api/geeks")
public class GeekService {

	@Autowired
	private GeekDao geekDao;
	
	@RequestMapping(method = RequestMethod.GET )
	public List<Geek> listAllGeek() {
	    return geekDao.findAll();
	}
	
}
