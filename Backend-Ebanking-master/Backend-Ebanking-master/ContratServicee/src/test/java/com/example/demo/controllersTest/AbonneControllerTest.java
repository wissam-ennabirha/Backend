package com.example.demo.controllersTest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.controllers.AbonneController;
import com.example.demo.entities.Abonne;
import com.example.demo.services.AbonneService;

public class AbonneControllerTest {
	public static Abonne A1;
    public static Abonne A2;
    public static Abonne A3;
    @InjectMocks
    AbonneController  abonneControlles;
      
     @Mock
     AbonneService abonneService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        A1 =new Abonne(1L,"dd@mlk","mlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
        A2 =new Abonne(2L,"dqqd@mlk","mqqlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
       A3=new Abonne(3L, "ffff", "fff", "fff", "44543", "wissam", "frr", "rrr", 33432, "rrr", false, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveAbonne() {
		 Mockito.when(abonneService.saveAbonne(A1)).thenReturn(A1);
	      assertEquals(abonneControlles.saveAbonne(A1),A1);
	       Mockito.verify(abonneService, Mockito.times(1)).saveAbonne(A1);
	}

	@Test
	public void testGetAbonne() {
		 Mockito.when(abonneService.getAbonne(1L)).thenReturn(A1);
	        Abonne A = abonneControlles.getAbonne(1L);
	        assertEquals(A, A1);
	}

	@Test
	public void testGetAbonnes() {
		   Mockito.when(abonneService.getAbonnes()).thenReturn(Arrays.asList(A1, A2));
	        assertEquals(abonneControlles.getAbonnes().size(), 2);
	        Mockito.verify(abonneService, Mockito.times(1)).getAbonnes();
	}

	@Test
	public void testUpdateAbonnet() {
	       Mockito.when(abonneService.getAbonne(1L)).thenReturn((A1));
	       Mockito.when(abonneService.updateAbonne(A1)).thenReturn(A3);
	      assertEquals(abonneControlles.updateAbonnet(A1), A3);
	      Mockito.verify(abonneService, Mockito.times(1)).updateAbonne(A1);
		
	}

	@Test
	public void testActivateAbonne() {
		 Mockito.when(abonneService.getAbonne(1L)).thenReturn(A1);
	        abonneService.activateAbonne(1L);
	        assertEquals(abonneControlles.getAbonne(1L).getIsActivated(),A1.getIsActivated());
	        Mockito.verify(abonneService, Mockito.times(1)).activateAbonne(1L);
		 
	}

	@Test
	public void testDesactivateAbonne() {
		 Mockito.when(abonneService.getAbonne(1L)).thenReturn(A1);
	        abonneService.desactivateAbonne(1L);
	        assertEquals(abonneControlles.getAbonne(1L).getIsActivated(),A1.getIsActivated());
	        Mockito.verify(abonneService, Mockito.times(1)).desactivateAbonne(1L);
	}

	@Test
	public void testDeleteAbonne() {
		Mockito.when(abonneService.getAbonne(1L)).thenReturn(A1);
        abonneControlles.deleteAbonne(1L);;
        Mockito.verify(abonneService, Mockito.times(1)).deleteAbonne(1L);
	}

}
