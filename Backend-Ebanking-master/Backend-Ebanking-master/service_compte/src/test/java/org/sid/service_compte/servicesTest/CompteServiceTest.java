package org.sid.service_compte.servicesTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.sid.service_compte.dao.CarteBancaireRepository;
import org.sid.service_compte.dao.CompteRepository;
import org.sid.service_compte.dao.OperationRepository;
import org.sid.service_compte.entities.CarteBancaire;
import org.sid.service_compte.entities.Compte;
import org.sid.service_compte.entities.Contrat;
import org.sid.service_compte.entities.Operation;
import org.sid.service_compte.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;



public class CompteServiceTest {
	public static Compte C1;
    public static Compte C2;
    public static Compte C3;
    
    public static Operation O1;
    public static CarteBancaire Ca1;
    public static Contrat Co1;
	@Autowired
	private  CompteService compteService;
	@MockBean
	private CompteRepository compteRepository;
	
	@MockBean
	private CarteBancaireRepository carteRepository;
	
	@MockBean
	private OperationRepository operationRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		C1= new Compte(1L, Formatter.parse("11-06-2019"), 1735, null, null,null);
		C2= new Compte(2L, Formatter.parse("11-06-2019"), 1735994, null, null,null);
		C3= new Compte(3L, Formatter.parse("11-06-2019"), 99373, null, null,null);
		O1=new Operation(1L, Formatter.parse("11-06-2019"));
		Ca1=new CarteBancaire(1L, "234", Formatter.parse("11-06-2019"), 345, "activer",C1);
		Co1=new Contrat(1L, Formatter.parse("11-06-2019"), "objectif", null, null, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertAbonne() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCompte() {
		Mockito.when(compteRepository.getOne(1L)).thenReturn(C1);
        Compte C = compteService.getCompte(1L);
        assertEquals(C, C1);
        Mockito.verify(compteRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testGetOperation() {
		Mockito.when(operationRepository.getOne(1L)).thenReturn(O1);
        Operation O= compteService.getOperation(1L);
        assertEquals(O, O1);
        Mockito.verify(operationRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testGetCarteBancaire() {
		Mockito.when(carteRepository.getOne(1L)).thenReturn(Ca1);
        CarteBancaire O= compteService.getCarteBancaire(1L);
        assertEquals(O, Ca1);
        Mockito.verify(carteRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testFindAllAccountsAbonne() {
       List<Compte> O= compteService.findAllAccountsAbonne(1L);
        Mockito.verify(compteRepository, Mockito.times(1)).findByContrat(Co1);	
	}

	@Test
	public void testFindAllAccounts() {
		Mockito.when(compteRepository.findAll()).thenReturn(Arrays.asList(C1,C2));
		assertEquals(compteService.findAllAccounts().size(),2);
        Mockito.verify(compteRepository, Mockito.times(1)).findAll(); 
	}

	@Test
	public void testFindAllOperations() {
		Mockito.when(compteRepository.getOne(1L)).thenReturn(C1);
        Mockito.verify(compteRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testFindAllCarteBancaire() {
		Mockito.when(compteRepository.getOne(1L)).thenReturn(C1);
        Mockito.verify(compteRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testDesactiveEtatCarte() {
		Mockito.when(carteRepository.getOne(1L)).thenReturn(Ca1);
		compteService.DesactiveEtatCarte(1L);   
       Mockito.verify(carteRepository, Mockito.times(1)).save(Ca1);
	}

	@Test
	public void testActiveEtatCarte() {
		Mockito.when(carteRepository.getOne(1L)).thenReturn(Ca1);
		compteService.ActiveEtatCarte(1L);   
       Mockito.verify(carteRepository, Mockito.times(1)).save(Ca1);
	}

}
