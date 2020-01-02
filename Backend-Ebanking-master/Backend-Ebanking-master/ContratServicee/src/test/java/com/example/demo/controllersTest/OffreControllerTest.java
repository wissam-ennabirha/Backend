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

import com.example.demo.controllers.OffreController;
import com.example.demo.entities.Offre;
import com.example.demo.services.OffreService;

public class OffreControllerTest {
	public static Offre O1;
    public static Offre O2;
    public static Offre O3;
    @InjectMocks
    OffreController offreControlles;
      
     @Mock
     OffreService offreService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		O1= new Offre(1L, Formatter.parse("11-06-2019"), Formatter.parse("11-06-2020"), true, true);
		O2=new Offre(2L, Formatter.parse("11-06-2019"), Formatter.parse("11-06-2020"), false, false);
		O3=new Offre(3L, Formatter.parse("11-06-2019"),Formatter.parse("11-06-2020"), true, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveCompte() {
		Mockito.when(offreService.saveOffre(O1)).thenReturn(O1);
	    assertEquals(offreControlles.saveCompte(O1),O1);
	    Mockito.verify(offreService, Mockito.times(1)).saveOffre(O1);
	}

	@Test
	public void testUpdateOffre() {
		 Mockito.when(offreService.getOffre(1L)).thenReturn((O1));
	       Mockito.when(offreService.updateAgence(O1)).thenReturn(O3);
	      assertEquals(offreControlles.updateOffre(O1), O3);
	      Mockito.verify(offreService, Mockito.times(1)).updateAgence(O1);
	}

	@Test
	public void testGetOffre() {
		Mockito.when(offreService.getOffre(1L)).thenReturn(O1);
        Offre O = offreControlles.getOffre(1L);
        assertEquals(O, O1);
	}

	@Test
	public void testGetOffres() {
		Mockito.when(offreService.getOffres()).thenReturn(Arrays.asList(O1, O2));
        assertEquals(offreControlles.getOffres().size(), 2);
        Mockito.verify(offreService, Mockito.times(1)).getOffres();
	}

	@Test
	public void testActivateEtatOffre() {
		offreControlles.activateEtatOffre(1L);  
		Mockito.verify(offreService, Mockito.times(1)).activateEtatOffre(1L);
	}

	@Test
	public void testDesaactivateEtatOffre() {
		offreControlles.desaactivateEtatOffre(1L);  
		Mockito.verify(offreService, Mockito.times(1)).desaactivateEtatOffre(1L);
	}

	@Test
	public void testChoix() {
		offreControlles.Choix(1L);  
		Mockito.verify(offreService, Mockito.times(1)).Choix(1L);
	}

	@Test
	public void testDesactivateChoix() {
		offreControlles.desactivateChoix(1L);  
		Mockito.verify(offreService, Mockito.times(1)).desactiveChoix(1L);
	}

}
