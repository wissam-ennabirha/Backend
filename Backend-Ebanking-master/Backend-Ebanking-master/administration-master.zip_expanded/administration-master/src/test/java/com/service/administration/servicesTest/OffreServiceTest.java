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
import com.service.administration.repository.CompteRepository;
import com.service.administration.repository.OffreRepository;
import com.service.administration.services.ConpteService;
import com.service.administration.services.OffreService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OffreServiceTest {
	public static Offre O1;
    public static Offre O2;
    public static Offre O3;
    @Autowired
   	private  OffreService offreService;
   	@MockBean
   	private OffreRepository offreRepository;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetOffres() {
		when(offreRepository.findAll()).thenReturn(Stream.of(O1, O2).collect(Collectors.toList()));
        assertEquals(offreService.getOffres().size(), 2);
        Mockito.verify(offreRepository, Mockito.times(1)).findAll();
	}

}
