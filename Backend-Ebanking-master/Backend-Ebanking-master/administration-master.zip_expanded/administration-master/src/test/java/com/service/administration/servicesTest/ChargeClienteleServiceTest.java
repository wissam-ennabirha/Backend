package com.service.administration.servicesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.administration.models.Agence;
import com.service.administration.models.Bo;
import com.service.administration.repository.AgenceRepository;
import com.service.administration.repository.ChargeClienteleRepository;
import com.service.administration.services.AgenceService;
import com.service.administration.services.ChargeClienteleService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeClienteleServiceTest {
	public static Bo B1;
    public static Bo B2;
    public static Bo B3;
    public static Agence A1;
    @Autowired
   	private  ChargeClienteleService boService;
   	@MockBean
   	private ChargeClienteleRepository boRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		A1=new Agence(1L, "safi", "safi", "safi", null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveChargeClientele() {
		 Mockito.when(boRepository.save(B1)).thenReturn(B1);
	      assertEquals(boService.saveChargeClientele(B1),B1);
	       Mockito.verify(boRepository, Mockito.times(1)).save(B1);
	}

	@Test
	public void testGetChargeClientele() {
		 Mockito.when(boRepository.getOne(1L)).thenReturn(B1);
	        Bo A = boService.getChargeClientele(1L);
	        assertEquals(A, B1);
	        Mockito.verify(boRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testGetChargeClienteles() {
		when(boRepository.findAll()).thenReturn(Stream.of(B1, B2).collect(Collectors.toList()));
        assertEquals(boService.getChargeClienteles().size(), 2);
        Mockito.verify(boRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void testUpdateChargeClientele() {
		 Mockito.when(boRepository.save(B1)).thenReturn(B1);
	      assertEquals(boService.updateChargeClientele(B1),B1);
	       Mockito.verify(boRepository, Mockito.times(1)).save(B1);
	}

	@Test
	public void testDeleteChargeClientele() {
		Mockito.when(boRepository.getOne(1L)).thenReturn(B1);
		boService.deleteChargeClientele(1L);
        Mockito.verify(boRepository, Mockito.times(1)).deleteById(1L); 
	}

	@Test
	public void testGetNumberOfBo() {
		Mockito.when(boRepository.countBoByAgence(A1)).thenReturn(1L);
		boService.getNumberOfBo(1L);
       Mockito.verify(boRepository, Mockito.times(1)).countBoByAgence(A1);
	}

	@Test
	public void testGetNumberofAllBos() {
		Mockito.when(boRepository.count()).thenReturn(1L);
		boService.getNumberofAllBos();
       Mockito.verify(boRepository, Mockito.times(1)).count();
	}

}
