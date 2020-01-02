package org.sid.servicetransaction.controllerTest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.sid.servicetransaction.controller.BeneficiareController;
import org.sid.servicetransaction.dao.AbonneRepository;
import org.sid.servicetransaction.entities.Abonne;
import org.sid.servicetransaction.entities.Beneficiare;
import org.sid.servicetransaction.service.BeneficiareService;
import org.springframework.beans.factory.annotation.Autowired;


public class BeneficiareControllerTest {
	public static Beneficiare B1;
	public static Beneficiare B2;
	public static Beneficiare B3;
	public static Abonne A1;
	@InjectMocks
    BeneficiareController  beneficaireControlles;
      
     @Mock
     BeneficiareService beneficaireService;

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		B1=new Beneficiare(1L, "wissam@gmail.com", "ennabirha", "wissam", "12345", 05357, "MD355", "hay essalam", A1);
		B2=new Beneficiare(2L, "wissam@gmail.com", "ennabirha", "wissam", "12345", 05357, "MD355", "hay essalam", A1);
		A1=new Abonne(1L, "ennabi@gmail.com", "wissam", "12345", "MDKG4567", "ennabirha", "wissam", "hay salam", 0563, "abonne", true, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListBeneficiare() {
		 Mockito.when(beneficaireService.listBeneficiare()).thenReturn(Arrays.asList(B1, B2));
	        assertEquals(beneficaireControlles.listBeneficiare().size(), 2);
	        Mockito.verify(beneficaireService, Mockito.times(1)).listBeneficiare();
	}

	@Test
	public void testListBeneficiareAbonne() {
		 Mockito.when(beneficaireService.listBeneficiareByAbonne(A1)).thenReturn(Arrays.asList(B1, B2));
	        assertEquals(beneficaireControlles.listBeneficiareAbonne(1L).size(), 2);
	        Mockito.verify(beneficaireService, Mockito.times(1)).listBeneficiareByAbonne(A1);
	}

	@Test
	public void testSaveBeneficiare() {
		 Mockito.when(beneficaireService.saveBeneficiare(B1)).thenReturn(B1);
	      assertEquals(beneficaireControlles.saveBeneficiare(B1),B1);
	       Mockito.verify(beneficaireService, Mockito.times(1)).saveBeneficiare(B1);
	}

	@Test
	public void testBeneficiare() {
		 Mockito.when(beneficaireService.getBeneficiare(1L)).thenReturn(B1);
	        Beneficiare A = beneficaireControlles.beneficiare(1L);
	        assertEquals(A, B1);
	}

	@Test
	public void testDeleteBeneficiare() {
		Mockito.when(beneficaireService.getBeneficiare(1L)).thenReturn(B1);
		beneficaireControlles.deleteBeneficiare(1L);;
        Mockito.verify(beneficaireService, Mockito.times(1)).deleteBeneficiare(1L);
	}

}
