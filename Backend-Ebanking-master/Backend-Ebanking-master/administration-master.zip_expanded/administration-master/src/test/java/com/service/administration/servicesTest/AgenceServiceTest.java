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


import com.service.administration.models.Agence;
import com.service.administration.repository.AbonneRepository;
import com.service.administration.repository.AgenceRepository;
import com.service.administration.services.AbonneService;
import com.service.administration.services.AgenceService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenceServiceTest {
	public static Agence A1;
    public static Agence A2;
    public static Agence A3;
    @Autowired
	private  AgenceService agenceService;
	@MockBean
	private AgenceRepository agenceRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveAgence() {
		 Mockito.when(agenceRepository.save(A1)).thenReturn(A1);
	      assertEquals(agenceService.saveAgence(A1),A1);
	       Mockito.verify(agenceRepository, Mockito.times(1)).save(A1);
	}

	@Test
	public void testGetAgence() {
		 Mockito.when(agenceRepository.getOne(1L)).thenReturn(A1);
	        Agence A = agenceService.getAgence(1L);
	        assertEquals(A, A1);
	        Mockito.verify(agenceRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testGetAgences() {
		when(agenceRepository.findAll()).thenReturn(Stream.of(A1, A2).collect(Collectors.toList()));
        assertEquals(agenceService.getAgences().size(), 2);
        Mockito.verify(agenceRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void testUpdateAgence() {
		 Mockito.when(agenceRepository.save(A1)).thenReturn(A1);
	      assertEquals(agenceService.updateAgence(A1),A1);
	       Mockito.verify(agenceRepository, Mockito.times(1)).save(A1);
	}

	@Test
	public void testDeleteAgence() {
		Mockito.when(agenceRepository.getOne(1L)).thenReturn(A1);
		agenceService.deleteAgence(1L);
        Mockito.verify(agenceRepository, Mockito.times(1)).deleteById(1L); 
	}

	@Test
	public void testGetNumberofAgence() {
		Mockito.when(agenceRepository.count()).thenReturn(1L);
		agenceService.getNumberofAgence();
       Mockito.verify(agenceRepository, Mockito.times(1)).count();
	}

}
