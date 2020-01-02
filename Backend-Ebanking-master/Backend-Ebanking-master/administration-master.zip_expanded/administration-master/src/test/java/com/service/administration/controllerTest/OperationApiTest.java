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

import com.service.administration.controller.OperationApi;
import com.service.administration.models.Operation;
import com.service.administration.services.OperationService;


public class OperationApiTest {
	public static Operation O1;
    public static Operation O2;
    public static Operation O3;
    @InjectMocks
    OperationApi operationControlles;
      
     @Mock
     OperationService operationService;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAgences() {
		Mockito.when(operationService.getOperations()).thenReturn(Arrays.asList(O1, O2));
        assertEquals(operationControlles.getAgences().size(), 2);
        Mockito.verify(operationService, Mockito.times(1)).getOperations();
	}

}
