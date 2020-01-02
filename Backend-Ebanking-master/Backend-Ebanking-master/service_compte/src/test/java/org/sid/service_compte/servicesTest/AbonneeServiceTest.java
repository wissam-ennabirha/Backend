package org.sid.service_compte.servicesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.sid.service_compte.dao.AbonneRepository;
import org.sid.service_compte.entities.Abonne;
import org.sid.service_compte.services.AbonneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;



public class AbonneeServiceTest {
	public static Abonne A1;
    public static Abonne A2;
    public static Abonne A3;
	@Autowired
	private  AbonneeService abonneService;
	@MockBean
	private AbonneRepository abonneRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        A1 =new Abonne(1L,"dd@mlk","mlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
        A2 =new Abonne(2L,"dqqd@mlk","mqqlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
       A3=new Abonne(3L, "ffff", "fff", "fff", "44543", "wissam", "frr", "rrr", 33432, "rrr", false, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAllAbonnee() {
		when(abonneRepository.findAll()).thenReturn(Stream.of(A1, A2).collect(Collectors.toList()));
        assertEquals(abonneService.findAllAbonnee().size(), 2);
        Mockito.verify(abonneRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void testInsererAbonne() {
		Mockito.when(abonneRepository.save(A1)).thenReturn(A1);
	      assertEquals(abonneService.insererAbonne(A1),A1);
	       Mockito.verify(abonneRepository, Mockito.times(1)).save(A1);
	}

}
