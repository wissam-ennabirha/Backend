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

import com.service.administration.controller.ChargeClientelApi;

import com.service.administration.models.Bo;

import com.service.administration.services.ChargeClienteleService;

public class ChargeClientelApiTest {
	public static Bo B1;
    public static Bo B2;
    public static Bo B3;
    @InjectMocks
    ChargeClientelApi  boControlles;
      
     @Mock
     ChargeClienteleService boService;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		B1=new Bo(1L, "wissam@gmail.com", "wissam", "345", "MC3456", "Enabirha", "Wissam", 0674433, null, null);
		B2=new Bo(2L, "wissam@gmail.com", "wissam", "345", "MC3456", "Enabirha", "Wissam", 0674433, null, null);
		B3=new Bo(2L, "wissam@gmail.com", "wissam", "345", "MC3456", "Enabirha", "Wissam", 0674433, null, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveAgence() {
		 Mockito.when(boService.saveChargeClientele(B1)).thenReturn(B1);
	      assertEquals(boControlles.saveAgence(B1),B1);
	       Mockito.verify(boService, Mockito.times(1)).saveChargeClientele(B1);
	}

	@Test
	public void testGetChargeClientel() {
		Mockito.when(boService.getChargeClientele(1L)).thenReturn(B1);
        Bo A = boControlles.getChargeClientel(1L);
        assertEquals(A, B1);
	}

	@Test
	public void testGetChargeClientels() {
		 Mockito.when(boService.getChargeClienteles()).thenReturn(Arrays.asList(B1, B2));
	        assertEquals(boControlles.getChargeClientels().size(), 2);
	        Mockito.verify(boService, Mockito.times(1)).getChargeClienteles();
	}

	@Test
	public void testUpdateAgence() {
		Mockito.when(boService.getChargeClientele(1L)).thenReturn((B1));
	       Mockito.when(boService.updateChargeClientele(B1)).thenReturn(B3);
	      assertEquals(boControlles.updateAgence(B1), B3);
	      Mockito.verify(boService, Mockito.times(1)).updateChargeClientele(B1);
	}

	@Test
	public void testDeleteAgence() {
		Mockito.when(boService.getChargeClientele(1L)).thenReturn(B1);
		boControlles.deleteAgence(1L);;
        Mockito.verify(boService, Mockito.times(1)).deleteChargeClientele(1L);
	}

	@Test
	public void testCountBosByAgence() {
		Mockito.when(boService.getNumberOfBo(1L)).thenReturn(1L);
		boControlles.countBosByAgence(1L);
       Mockito.verify(boService, Mockito.times(1)).getNumberOfBo(1L);
	}

	@Test
	public void testCountBos() {
		Mockito.when(boService.getNumberofAllBos()).thenReturn(1L);
		boControlles.countBos();
       Mockito.verify(boService, Mockito.times(1)).getNumberofAllBos();
	}

}
