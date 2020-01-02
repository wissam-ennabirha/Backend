package com.service.administration.controllerTest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.service.administration.controller.AgenceApi;
import com.service.administration.models.Agence;
import com.service.administration.repository.AgenceRepository;
import com.service.administration.services.AgenceService;

;

public class AgenceApiTest {
	public static Agence A1;
    public static Agence A2;
    public static Agence A3;
    @InjectMocks
    AgenceApi  agenceControlles;
      
     @Mock
     AgenceService agenceService;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		A1=new Agence(1L, "miftah lkhayr", "safi", "oum rabi3 miftah lkhair", null);
		A2=new Agence(2L, "hay salam ", "safi", "oum rabi3  lkhair", null);
		A3=new Agence(3L, "safi", "safi", "safi", null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveAgence() {
		Mockito.when(agenceService.saveAgence(A1)).thenReturn(A1);
	      assertEquals(agenceControlles.saveAgence(A1),A1);
	       Mockito.verify(agenceService, Mockito.times(1)).saveAgence(A1);
	}

	@Test
	public void testGetAgence() {
		 Mockito.when(agenceService.getAgence(1L)).thenReturn(A1);
	        Agence A = agenceControlles.getAgence(1L);
	        assertEquals(A, A1);
	}

	@Test
	public void testGetAgences() {
		Mockito.when(agenceService.getAgences()).thenReturn(Arrays.asList(A1, A2));
        assertEquals(agenceControlles.getAgences().size(), 2);
        Mockito.verify(agenceService, Mockito.times(1)).getAgences();

	}

	@Test
	public void testUpdateAgence() {
		 Mockito.when(agenceService.getAgence(1L)).thenReturn((A1));
	       Mockito.when(agenceService.updateAgence(A1)).thenReturn(A3);
	      assertEquals(agenceControlles.updateAgence(A1), A3);
	      Mockito.verify(agenceService, Mockito.times(1)).updateAgence(A1);
	}

	@Test
	public void testDeleteAgence() {
		Mockito.when(agenceService.getAgence(1L)).thenReturn(A1);
		agenceControlles.deleteAgence(1L);;
        Mockito.verify(agenceService, Mockito.times(1)).deleteAgence(1L);
	}

	@Test
	public void testCountAgence() {
		Mockito.when(agenceService.getNumberofAgence()).thenReturn(1L);
		 agenceControlles.countAgence();
        Mockito.verify(agenceService, Mockito.times(1)).getNumberofAgence();
	}

}
