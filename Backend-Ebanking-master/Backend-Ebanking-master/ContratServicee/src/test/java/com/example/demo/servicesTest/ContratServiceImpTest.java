package com.example.demo.servicesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Repositories.BoRepository;
import com.example.demo.Repositories.ContratRepository;
import com.example.demo.entities.Bo;
import com.example.demo.entities.Contrat;
import com.example.demo.services.ContratService;

public class ContratServiceImpTest {
	public static Contrat C1;
    public static Contrat C2;
    public static Contrat C3;
	@Autowired
	private  ContratService contratService;
	@Autowired
    BoRepository boRepository;
	@MockBean
	private ContratRepository contratRepository;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		C1=new Contrat(1L,Formatter.parse("11-06-2019"), "effecuter transaction", null, null,null);
		C2=new Contrat(2L,Formatter.parse("11-06-2019"), "effecuter transaction", null, null,null);
		C3=new Contrat(3L,Formatter.parse("11-06-2019"), "effecuter transaction", null, null,null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveContrat() {
		Mockito.when(contratRepository.save(C1)).thenReturn(C1);
	      assertEquals(contratService.saveContrat(C1),C1);
	       Mockito.verify(contratRepository, Mockito.times(1)).save(C1);
	}

	@Test
	public void testGetContrat() {
		 Mockito.when(contratRepository.getOne(1L)).thenReturn(C1);
	        Contrat C = contratService.getContrat(1L);
	        assertEquals(C, C1);
	        Mockito.verify(contratRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testUpdateContrat() {
		Mockito.when(contratRepository.save(C1)).thenReturn(C1);
	      assertEquals(contratService.updateContrat(C1),C1);
	       Mockito.verify(contratRepository, Mockito.times(1)).save(C1);
	}

	@Test
	public void testDeleteContrat() {
		Mockito.when(contratRepository.getOne(1L)).thenReturn(C1);
		contratService.deleteContrat(1L);
        Mockito.verify(contratRepository, Mockito.times(1)).deleteById(1L); 
	}

	@Test
	public void testGetContrats() {
		when(contratRepository.findAll()).thenReturn(Stream.of(C1, C2).collect(Collectors.toList()));
        assertEquals(contratService.getContrats().size(), 2);
        Mockito.verify(contratRepository, Mockito.times(1)).findAll();
	}



}
