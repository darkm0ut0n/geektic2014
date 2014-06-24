package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Geek.Interest;

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
	
	public List<Geek> findByCriteria(Integer sex, Interest interest) {
		String jpql = "select g from Geek as g where 1=1 ";
		if(sex != null) {
			jpql += "and sex=:sex ";
		}
		if(interest != null) {
			jpql += "and interest=:interest ";
		}
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		if(sex != null) {
			query.setParameter("sex", sex);
		}
		if(interest != null) {
			query.setParameter("interest", interest);
		}
		
		return query.getResultList();
	}
}
