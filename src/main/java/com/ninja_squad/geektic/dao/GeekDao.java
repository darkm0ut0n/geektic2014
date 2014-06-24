package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;

@Repository
public class GeekDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Geek findById(Long id) {
		return entityManager.find(Geek.class, id);
	}
	
	public List<Geek> findAll() {
		String jpql = "select g from Geek as g";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		return query.getResultList();
	}
}
