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

import com.service.administration.controller.ContratApi;
import com.service.administration.models.Contrat;
import com.service.administration.services.ContratService;



public class ContratApiTest {
	public static Contrat C1;
    public static Contrat C2;
    public static Contrat C3;
    @InjectMocks
    ContratApi contratControlles;
      
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
	public void testGetChargeClientels() {
		Mockito.when(contratService.getContrats()).thenReturn(Arrays.asList(C1, C2));
        assertEquals(contratControlles.getChargeClientels().size(), 2);
        Mockito.verify(contratService, Mockito.times(1)).getContrats();
	}

}
