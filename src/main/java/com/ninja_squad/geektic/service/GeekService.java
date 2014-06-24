package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Geek.Interest;

@RestController
@Transactional
@RequestMapping("/api/geeks")
public class GeekService {

	@Autowired
	private GeekDao geekDao;
	
	@RequestMapping(method = RequestMethod.GET )
	public List<Geek> listAllGeeks() {
	    return geekDao.findAll();
	}
	
	@RequestMapping(value="/interest", method = RequestMethod.GET)
	public List<Geek> listGeeksByCriteria(@RequestParam(value="sex", required=false) Integer sex, @RequestParam(value="interest", required=false) Interest interest) {
		return geekDao.findByCriteria(sex, interest);
	}
}
