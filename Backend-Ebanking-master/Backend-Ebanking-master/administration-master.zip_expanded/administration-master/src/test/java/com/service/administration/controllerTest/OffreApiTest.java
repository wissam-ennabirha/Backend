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

import com.service.administration.controller.OffreApi;
import com.service.administration.models.Offre;
import com.service.administration.services.OffreService;



public class OffreApiTest {
	public static Offre O1;
    public static Offre O2;
    public static Offre O3;
    @InjectMocks
    OffreApi offreControlles;
      
     @Mock
     OffreService offreService;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		O1= new Offre(1L, Formatter.parse("11-06-2019"), Formatter.parse("11-06-2020"), true, true);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAgences() {
		Mockito.when(offreService.getOffres()).thenReturn(Arrays.asList(O1, O2));
        assertEquals(offreControlles.getAgences().size(), 2);
        Mockito.verify(offreService, Mockito.times(1)).getOffres();
	}

}
