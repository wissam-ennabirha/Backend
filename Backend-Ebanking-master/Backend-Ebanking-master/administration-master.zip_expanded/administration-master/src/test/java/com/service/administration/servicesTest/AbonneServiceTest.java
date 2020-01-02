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

import com.service.administration.models.Abonne;
import com.service.administration.repository.AbonneRepository;
import com.service.administration.services.AbonneService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AbonneServiceTest {
	public static Abonne A1;
    public static Abonne A2;
    public static Abonne A3;
	@Autowired
	private  AbonneService abonneService;
	@MockBean
	private AbonneRepository abonneRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAbonnes() {
		when(abonneRepository.findAll()).thenReturn(Stream.of(A1, A2).collect(Collectors.toList()));
        assertEquals(abonneService.getAbonnes().size(), 2);
        Mockito.verify(abonneRepository, Mockito.times(1)).findAll();
	}

}
