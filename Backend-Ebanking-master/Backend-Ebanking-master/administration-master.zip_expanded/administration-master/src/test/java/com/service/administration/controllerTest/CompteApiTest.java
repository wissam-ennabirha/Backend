package com.service.administration.controllerTest;

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

import com.service.administration.controller.AgenceApi;
import com.service.administration.controller.CompteApi;
import com.service.administration.models.Agence;
import com.service.administration.models.Compte;
import com.service.administration.services.AgenceService;
import com.service.administration.services.CompteServiceI;

public class CompteApiTest {
	public static Compte C1;
    public static Compte C2;
    public static Compte C3;
    @InjectMocks
    CompteApi  compteControlles;
      
     @Mock
     CompteServiceI compteService;

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
	public void testGetChargeClientels() {
		 Mockito.when(compteService.getComptes()).thenReturn(Arrays.asList(C1, C2));
	        assertEquals(compteControlles.getChargeClientels().size(), 2);
	        Mockito.verify(compteService, Mockito.times(1)).getComptes();
	}

}
