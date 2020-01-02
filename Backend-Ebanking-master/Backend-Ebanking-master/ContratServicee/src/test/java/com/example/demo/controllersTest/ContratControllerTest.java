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

import com.example.demo.controllers.ContratController;
import com.example.demo.entities.Contrat;
import com.example.demo.services.ContratService;

public class ContratControllerTest {
	public static Contrat C1;
    public static Contrat C2;
    public static Contrat C3;
    @InjectMocks
    ContratController contratControlles;
      
     @Mock
     ContratService contratService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		C1=new Contrat(1L,Formatter.parse("11-06-2019"), "effecuter transaction", null, null,null);
		C2=new Contrat(2L,Formatter.parse("11-06-2019"), "effecuter transaction", null, null,null);
		C3=new Contrat(3L,Formatter.parse("11-06-2019"), "effecuter transaction", null, null,null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveContrat() {
		 Mockito.when(contratService.saveContrat(C1)).thenReturn(C1);
	      assertEquals(contratControlles.saveContrat(C1),C1);
	    Mockito.verify(contratService, Mockito.times(1)).saveContrat(C1);
	}

	@Test
	public void testGetChargeClientel() {
		 Mockito.when(contratService.getContrat(1L)).thenReturn(C1);
	        Contrat C = contratControlles.getChargeClientel(1L);
	        assertEquals(C, C1);
	        Mockito.verify(contratService, Mockito.times(1)).getContrat(1L);
	}

	@Test
	public void testGetContrats() {
		Mockito.when(contratService.getContrats()).thenReturn(Arrays.asList(C1, C2));
        assertEquals(contratControlles.getContrats().size(), 2);
        Mockito.verify(contratService, Mockito.times(1)).getContrats();
	}

	@Test
	public void testUpdateContrat() {
		 Mockito.when(contratService.getContrat(1L)).thenReturn((C1));
	       Mockito.when(contratService.updateContrat(C1)).thenReturn(C3);
	      assertEquals(contratControlles.updateContrat(C1), C3);
	      Mockito.verify(contratService, Mockito.times(1)).updateContrat(C1);
	}

	@Test
	public void testDeleteContrat() {
		Mockito.when(contratService.getContrat(1L)).thenReturn(C1);
		contratControlles.deleteContrat(1L);
        Mockito.verify(contratService, Mockito.times(1)).deleteContrat(1L);
	}

	@Test
	public void testGetallcontratbyabonne() {
		Mockito.when(contratService.getallcontrats(1L)).thenReturn(Arrays.asList(C1, C2));
        assertEquals(contratControlles.getallcontratbyabonne(1L).size(), 2);
        Mockito.verify(contratService, Mockito.times(1)).getallcontrats(1L);
	}

}
