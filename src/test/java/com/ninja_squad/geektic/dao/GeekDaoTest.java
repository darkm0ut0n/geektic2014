package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import java.util.List;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.entity.Geek;

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
		          .values(1L, "Geekette", 0, "some_url", "JAVA")
				  .values(2L, "Toto", 1, "another_url", "C#")
				  .values(3L, "Tata", 0, "tata_url", "C++")
		          .build());
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void findById_test() {
        assertEquals("Geekette", geekDao.findById(1l).getPseudo());
    }
    
    @Test
    public void findAll_test() {
    	List<Geek> geeks = geekDao.findAll();
    	assertEquals(3, geeks.size());
    }
}
