package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import java.util.List;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Geek.Interest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GeekDaoTest extends BaseDaoTest {

    @Autowired
    private GeekDao geekDao;

    @Before
    public void populateDatabase() {
    	Operation operation = Operations.sequenceOf(
			Operations.deleteAllFrom("geek"),
			Operations.insertInto("geek")
			.columns("id_geek", "pseudo", "sex", "gravatar_url", "interest")
			.values(1L, "Geekette", 0, "some_url", Interest.Java)
			.values(2L, "Toto", 1, "another_url", Interest.C)
			.values(3L, "Tata", 0, "tata_url", Interest.JUnit)
			.build());
    	DbSetup dbSetup = new DbSetup(destination, operation);
    	dbSetup.launch();
    }

    @Test
    public void findByIdTest() {
        assertEquals("Geekette", geekDao.findById(1l).getPseudo());
    }
    
    @Test
    public void findAllTest() {
    	List<Geek> geeks = geekDao.findAll();
    	assertEquals(3, geeks.size());
    }
    
    @Test
    public void findByCriteriaTest_noCriteria() {
    	List<Geek> allGeeks = geekDao.findAll();
    	List<Geek> filteredGeeks = geekDao.findByCriteria(null, null);
    	assertTrue(filteredGeeks.equals(allGeeks));
    }
    
    @Test
    public void findByCriteriaTest_OnlyWomen() {
    	List<Geek> filteredGeeks = geekDao.findByCriteria(0, null);
    	assertEquals(2, filteredGeeks.size());
    	assertFalse(filteredGeeks.contains(2L)); // filteredGeek should not contain Toto which is a man
    }
    
    @Test
    public void findByCriteriaTest_OnlyInterestedByJunit() {
    	List<Geek> filteredGeeks = geekDao.findByCriteria(null, Interest.JUnit);
    	assertEquals(3, filteredGeeks.get(0).getId().intValue());
    }
    
    @Test
    public void findByCriteriaTest_MenInterestedByJunit() {
    	List<Geek> filteredGeeks = geekDao.findByCriteria(1, Interest.JUnit);
    	assertEquals(0, filteredGeeks.size());
    }
}
