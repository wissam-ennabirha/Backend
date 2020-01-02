package com.example.demo.controllersTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.controllers.CompteController;
import com.example.demo.entities.Compte;
import com.example.demo.services.CompteService;

public class CompteControllerTest {
	public static Compte C1;
    public static Compte C2;
    public static Compte C3;
    @InjectMocks
    CompteController compteControlles;
      
     @Mock
     CompteService compteService;

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
		 Mockito.when(compteService.saveCompte(C1)).thenReturn(C1);
	      assertEquals(compteControlles.saveCompte(C1),C1);
	    Mockito.verify(compteService, Mockito.times(1)).saveCompte(C1);
	}

	@Test
	public void testGetCompteLong() {
		  Mockito.when(compteService.getComptes()).thenReturn(Arrays.asList(C1, C2));
	        assertEquals(compteControlles.getCompte().size(), 2);
	        Mockito.verify(compteService, Mockito.times(1)).getComptes();
	}

	@Test
	public void testGetCompte() {
	      Mockito.when(compteService.getCompte(1L)).thenReturn(C1);
	        Compte C = compteControlles.getCompte(1L);
	        assertEquals(C, C1);
	}

	@Test
	public void testUpdateCompte() {
		 Mockito.when(compteService.getCompte(1L)).thenReturn((C1));
	       Mockito.when(compteService.updateComptet(C1)).thenReturn(C3);
	      assertEquals(compteControlles.updateCompte(C1), C3);
	      Mockito.verify(compteService, Mockito.times(1)).updateComptet(C1);
	}

	@Test
	public void testDeleteCompte() {
			Mockito.when(compteService.getCompte(1L)).thenReturn(C1);
	        compteControlles.deleteCompte(1L);;
	        Mockito.verify(compteService, Mockito.times(1)).deleteCompte(1L);

	}

	@Test
	public void testRetirer() {
		Mockito.when(compteService.getCompte(1L)).thenReturn(C1);
        compteControlles.retirer(1L);
        Mockito.verify(compteService, Mockito.times(1)).Prelement(1L);
	}

}
