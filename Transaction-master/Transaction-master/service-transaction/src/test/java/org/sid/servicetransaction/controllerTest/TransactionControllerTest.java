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

import org.sid.servicetransaction.controller.TransactionController;
import org.sid.servicetransaction.dao.CompteRepository;
import org.sid.servicetransaction.dao.OffreRepository;
import org.sid.servicetransaction.entities.Compte;
import org.sid.servicetransaction.entities.Offre;
import org.sid.servicetransaction.entities.Virement;
import org.sid.servicetransaction.service.TransactionService;




public class TransactionControllerTest {
	public static Virement V1;
	public static Virement V2;
	
	public static Offre O1;
	public static Offre O2;
	
	public static Compte C1;
	
	
	 @InjectMocks
	    public TransactionController  transactionControlles;
	      
	     @Mock
	     public TransactionService transactionService;
	     @Mock 
	     public CompteRepository compteRepositiry;
	     @Mock
	     public OffreRepository offreRepository;
	     @Mock
	     public CompteRepository compteRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListVirements() {
		 Mockito.when(transactionService.listeVirements()).thenReturn(Arrays.asList(V1, V2));
	        assertEquals(transactionControlles.listVirements().size(), 2);
	        Mockito.verify(transactionService, Mockito.times(1)).listeVirements();
	}

	@Test
	public void testListOffre() {
		 Mockito.when(offreRepository.findAll()).thenReturn(Arrays.asList(O1, O2));
	        assertEquals(transactionControlles.listOffre().size(), 2);
	        Mockito.verify(offreRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void testOffreById() {
		 Mockito.when(offreRepository.getOne(1L)).thenReturn(O1);
	        Offre A = transactionControlles.offreById(1L);
	        assertEquals(A, O1);
	        Mockito.verify(offreRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testListVirementsByCompte() {
		 Mockito.when(transactionService.listeVirementsByCompte(compteRepositiry.getOne(1L))).thenReturn(Arrays.asList(V1, V2));
	        assertEquals(transactionControlles.listVirementsByCompte(1L).size(), 2);
	        Mockito.verify(transactionService, Mockito.times(1)).listeVirementsByCompte(compteRepositiry.getOne(1L));
	}

	@Test
	public void testListVirementsByType() {
		 Mockito.when(transactionService.listeVirementsByType("CC")).thenReturn(Arrays.asList(V1, V2));
	        assertEquals(transactionControlles.listVirementsByType("CC").size(), 2);
	        Mockito.verify(transactionService, Mockito.times(1)).listeVirementsByType("CC");
	}

	@Test
	public void testVirementById() {
		 Mockito.when(transactionService.virementById(1L)).thenReturn(V1);
		  Virement A = transactionControlles.virementById(1L);
	        assertEquals(A, V1);
	}

	@Test
	public void testSaveVirement() {
		 Mockito.when(transactionService.saveVirement(V1)).thenReturn(V1);
	      assertEquals(transactionControlles.saveVirement(V1),V1);
	       Mockito.verify(transactionService, Mockito.times(1)).saveVirement(V1);
	}

	@Test
	public void testSaveVirementBeneficiare() {
		 Mockito.when(transactionService.saveVirementBeneficiare(V1)).thenReturn(V1);
	      assertEquals(transactionControlles.saveVirementBeneficiare(V1),V1);
	       Mockito.verify(transactionService, Mockito.times(1)).saveVirementBeneficiare(V1);
	}

	@Test
	public void testSaveCompte() {
		Mockito.when(compteRepository.save(C1)).thenReturn(C1);
	      assertEquals(transactionControlles.saveCompte(C1),C1);
	       Mockito.verify(compteRepository, Mockito.times(1)).save(C1);
	}

	@Test
	public void testDeleteVirement() {
		 Mockito.when(transactionService.virementById(1L)).thenReturn(V1);
		transactionControlles.deleteVirement(1L);;
        Mockito.verify(transactionService, Mockito.times(1)).deleteVirement(V1);
	}

}
