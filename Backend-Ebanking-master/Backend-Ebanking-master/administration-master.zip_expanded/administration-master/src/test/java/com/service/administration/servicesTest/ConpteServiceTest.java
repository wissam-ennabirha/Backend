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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.administration.models.Compte;
import com.service.administration.repository.AgenceRepository;
import com.service.administration.repository.CompteRepository;
import com.service.administration.services.AgenceService;
import com.service.administration.services.ConpteService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConpteServiceTest {
	public static Compte C1;
    public static Compte C2;
    public static Compte C3;
    
    @Autowired
	private  ConpteService compteService;
	@MockBean
	private CompteRepository compteRepository;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetComptes() {
		when(compteRepository.findAll()).thenReturn(Stream.of(C1, C2).collect(Collectors.toList()));
        assertEquals(compteService.getComptes().size(), 2);
        Mockito.verify(compteRepository, Mockito.times(1)).findAll();
	}

}
