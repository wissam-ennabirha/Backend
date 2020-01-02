package com.service.administration.servicesTest;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.administration.models.Offre;
import com.service.administration.models.Operation;
import com.service.administration.repository.OffreRepository;
import com.service.administration.repository.OperationRepository;
import com.service.administration.services.OffreService;
import com.service.administration.services.OperationService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationServiceTest {
	public static Operation O1;
    public static Operation O2;
    public static Operation O3;
    
    @Autowired
   	private  OperationService operationService;
   	@MockBean
   	private OperationRepository operationRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOperations() {
		when(operationRepository.findAll()).thenReturn(Stream.of(O1, O2).collect(Collectors.toList()));
        assertEquals(operationService.getOperations().size(), 2);
        Mockito.verify(operationRepository, Mockito.times(1)).findAll();
	}

}
