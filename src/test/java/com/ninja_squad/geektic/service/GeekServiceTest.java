package com.ninja_squad.geektic.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.entity.Geek;

public class GeekServiceTest {

	@Mock
	private GeekDao geekDao;

	@InjectMocks
	private GeekService geekService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void incrementConsultedTest() {
		Geek mockedGeek = new Geek();
		mockedGeek.setConsulted(0);
		Mockito.when(geekDao.findById(1L)).thenReturn(mockedGeek);
		assertEquals(1, geekService.incrementConsulted(1L));
		assertEquals(1, geekDao.findById(1L).getConsulted());
	}
}
