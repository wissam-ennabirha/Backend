package org.sid.service_compte.webTest;

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
import org.sid.service_compte.entities.Abonne;
import org.sid.service_compte.entities.CarteBancaire;
import org.sid.service_compte.entities.Compte;
import org.sid.service_compte.entities.Operation;
import org.sid.service_compte.entities.Virement;
import org.sid.service_compte.services.AbonneeService;
import org.sid.service_compte.services.CompteService;
import org.sid.service_compte.web.CompteController;




public class CompteControllerTest {
	public static Compte C1;
    public static Compte C2;
    public static Compte C3;
    
    public static Abonne A1;
    public static Abonne A2;
    public static Abonne A3;
    
    public static Operation O1;
    
    public static CarteBancaire Ca1;
    
    public static Virement V1;
    @InjectMocks
    CompteController compteControlles;
      
     @Mock
     CompteService compteService;
     
    
       
      @Mock
      AbonneeService abonneService;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		C1= new Compte(1L, Formatter.parse("11-06-2019"), 1735, null, null,null);
		C2= new Compte(2L, Formatter.parse("11-06-2019"), 1735994, null, null,null);
		C3= new Compte(3L, Formatter.parse("11-06-2019"), 99373, null, null,null);
		
		A1 =new Abonne(1L,"dd@mlk","mlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
        A2 =new Abonne(2L,"dqqd@mlk","mqqlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
       A3=new Abonne(3L, "ffff", "fff", "fff", "44543", "wissam", "frr", "rrr", 33432, "rrr", false, null);
       
       O1=new Operation(1L, Formatter.parse("11-06-2019"));
       
       Ca1=new CarteBancaire(1L, "123", Formatter.parse("11-06-2019"), 3456, "activer", C1);
       V1=new Virement(1L, Formatter.parse("11-06-2019"), 3456, C1, "1", "versement");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAllContrat() {
		
	}

	@Test
	public void testAllAbonne() {
		 Mockito.when(abonneService.findAllAbonnee()).thenReturn(Arrays.asList(A1, A2));
	        assertEquals(compteControlles.allAbonne().size(), 2);
	        Mockito.verify(abonneService, Mockito.times(1)).findAllAbonnee();

	}

	@Test
	public void testInsertAbonne() {
		Mockito.when(abonneService.insererAbonne(A1)).thenReturn(A1);
	      assertEquals(compteControlles.insertAbonne(A1),A1);
	       Mockito.verify(abonneService, Mockito.times(1)).insererAbonne(A1);
	}

	@Test
	public void testSaveCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAbonne() {
		 Mockito.when(compteService.findAllAccountsAbonne(1L)).thenReturn(Arrays.asList(C1, C2));
		 assertEquals(compteControlles.getAbonne(1L).size(), 2);
	        Mockito.verify(compteService, Mockito.times(1)).findAllAccountsAbonne(1L);
	}

	@Test
	public void testFindAllAccunt() {
		Mockito.when(compteService.findAllAccounts()).thenReturn(Arrays.asList(C1, C2));
		 assertEquals(compteControlles.findAllAccunt().size(), 2);			
	        Mockito.verify(compteService, Mockito.times(1)).findAllAccounts();
	}

	@Test
	public void testGetCompte() {
		Mockito.when(compteService.getCompte(1L)).thenReturn(C1);
		 assertEquals(compteControlles.getCompte(1L), C1);
	        Mockito.verify(compteService, Mockito.times(1)).getCompte(1L);
	}

	@Test
	public void testGetOperationbyId() {
		Mockito.when(compteService.getOperation(1L)).thenReturn(O1);
		 assertEquals(compteControlles.getOperationbyId(1L), O1);
	        Mockito.verify(compteService, Mockito.times(1)).getOperation(1L);
	}

	@Test
	public void testGetCarteBancairebyId() {
		Mockito.when(compteService.getCarteBancaire(1L)).thenReturn(Ca1);
		 assertEquals(compteControlles.getCarteBancaire(1L), Ca1);
	        Mockito.verify(compteService, Mockito.times(1)).getCarteBancaire(1L);
	}

	@Test
	public void testGetOperation() {
		Mockito.when(compteService.findAllOperations(1L)).thenReturn(Arrays.asList(V1));
		 assertEquals(compteControlles.getOperation(1L).size(), 1);
	        Mockito.verify(compteService, Mockito.times(1)).findAllOperations(1L);
	}

	@Test
	public void testGetCarteBancaire() {
		Mockito.when(compteService.findAllCarteBancaire(1L)).thenReturn(Ca1);
		 assertEquals(compteControlles.getCarteBancaire(1L), Ca1);
	        Mockito.verify(compteService, Mockito.times(1)).findAllCarteBancaire(1L);
	}

	@Test
	public void testDesactiverEtatCarte() {
		 Mockito.when(compteService.getCarteBancaire(1L)).thenReturn(Ca1);
		 compteService.DesactiveEtatCarte(1L);
	        Mockito.verify(compteService, Mockito.times(1)).DesactiveEtatCarte(1L);
	}

	@Test
	public void testActiverEtatCarte() {
		 Mockito.when(compteService.getCarteBancaire(1L)).thenReturn(Ca1);
		 compteService.ActiveEtatCarte(1L);
	        Mockito.verify(compteService, Mockito.times(1)).ActiveEtatCarte(1L);
	}

}
