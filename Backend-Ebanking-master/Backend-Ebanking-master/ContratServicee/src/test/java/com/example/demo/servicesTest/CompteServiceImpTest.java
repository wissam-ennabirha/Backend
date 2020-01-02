package com.example.demo.servicesTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

import com.example.demo.Repositories.CompteRepository;
import com.example.demo.entities.Compte;
import com.example.demo.services.CompteService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompteServiceImpTest {
	public static Compte C1;
    public static Compte C2;
    public static Compte C3;
	@Autowired
	private  CompteService compteService;
	@MockBean
	private CompteRepository compteRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		C1= new Compte(1L, Formatter.parse("11-06-2019"), 1735, null, null,null);
		C2= new Compte(2L, Formatter.parse("11-06-2019"), 1735994, null, null,null);
		C3= new Compte(3L, Formatter.parse("11-06-2019"), 99373, null, null,null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveCompte() {
		Mockito.when(compteRepository.save(C1)).thenReturn(C1);
	      assertEquals(compteService.saveCompte(C1),C1);
	       Mockito.verify(compteRepository, Mockito.times(1)).save(C1);
	}

	@Test
	public void testGetCompte() {
		Mockito.when(compteRepository.getOne(1L)).thenReturn(C1);
        Compte C = compteService.getCompte(1L);
        assertEquals(C, C1);
        Mockito.verify(compteRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testUpdateComptet() {
		 Mockito.when(compteRepository.save(C1)).thenReturn(C1);
	      assertEquals(compteService.updateComptet(C1),C1);
	       Mockito.verify(compteRepository, Mockito.times(1)).save(C1);
	}

	@Test
	public void testDeleteCompte() {
		Mockito.when(compteRepository.getOne(1L)).thenReturn(C1);
		compteService.deleteCompte(1L);
        Mockito.verify(compteRepository, Mockito.times(1)).deleteById(1L); 
	}

	@Test
	public void testGetComptes() {
		Mockito.when(compteRepository.findAll()).thenReturn(Arrays.asList(C1,C2));
		assertEquals(compteService.getComptes().size(),2);
        Mockito.verify(compteRepository, Mockito.times(1)).findAll(); 
	}

	

}
