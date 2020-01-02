package org.sid.servicetransaction.serviceTest;

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
import org.sid.servicetransaction.dao.VirementRepository;
import org.sid.servicetransaction.entities.Compte;
import org.sid.servicetransaction.entities.Offre;
import org.sid.servicetransaction.entities.Virement;
import org.sid.servicetransaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {
	public static Virement V1;
	public static Virement V2;
	
	public static Offre O1;
	public static Offre O2;
	
	public static Compte C1;
	
	@Autowired
	private  TransactionService transactionService;
	@MockBean
	private VirementRepository virementRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListeVirements() {
		when(virementRepository.findAll()).thenReturn(Stream.of(V1, V2).collect(Collectors.toList()));
        assertEquals(transactionService.listeVirements().size(), 2);
        Mockito.verify(virementRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void testListeVirementsByCompte() {
		when(virementRepository.findByCompte(C1)).thenReturn(Stream.of(V1, V2).collect(Collectors.toList()));
        assertEquals(transactionService.listeVirementsByCompte(C1).size(), 2);
        Mockito.verify(virementRepository, Mockito.times(1)).findByCompte(C1);
	}

	@Test
	public void testListeVirementsByType() {
		when(virementRepository.findByType("CC")).thenReturn(Stream.of(V1, V2).collect(Collectors.toList()));
        assertEquals(transactionService.listeVirementsByType("CC").size(), 2);
        Mockito.verify(virementRepository, Mockito.times(1)).findByType("CC");
	}

	@Test
	public void testVirementById() {
		 Mockito.when(virementRepository.getOne(1L)).thenReturn(V1);
	        Virement A = transactionService.virementById(1L);
	        assertEquals(A, V1);
	        Mockito.verify(virementRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testSaveVirement() {
		Mockito.when(virementRepository.save(V1)).thenReturn(V1);
	      assertEquals(transactionService.saveVirement(V1),V1);
	       Mockito.verify(virementRepository, Mockito.times(1)).save(V1);
	}

	@Test
	public void testSaveVirementBeneficiare() {
		Mockito.when(virementRepository.save(V1)).thenReturn(V1);
	      assertEquals(transactionService.saveVirementBeneficiare(V1),V1);
	       Mockito.verify(virementRepository, Mockito.times(1)).save(V1);
	}

	@Test
	public void testDeleteVirement() {
		Mockito.when(virementRepository.getOne(1L)).thenReturn(V1);
		transactionService.deleteVirement(V1);
        Mockito.verify(virementRepository, Mockito.times(1)).delete(V1); 
	}

}
