package com.example.demo.servicesTest;

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

import com.example.demo.Repositories.AbonneRepository;
import com.example.demo.entities.Abonne;
import com.example.demo.services.AbonneService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AbonneServiceImpTest {
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
        A1 =new Abonne(1L,"dd@mlk","mlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
        A2 =new Abonne(2L,"dqqd@mlk","mqqlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
       A3=new Abonne(3L, "ffff", "fff", "fff", "44543", "wissam", "frr", "rrr", 33432, "rrr", false, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveAbonne() {
		  Mockito.when(abonneRepository.save(A1)).thenReturn(A1);
	      assertEquals(abonneService.saveAbonne(A1),A1);
	       Mockito.verify(abonneRepository, Mockito.times(1)).save(A1);
	}

	@Test
	public void testGetAbonne() {
	    Mockito.when(abonneRepository.getOne(1L)).thenReturn(A1);
        Abonne A = abonneService.getAbonne(1L);
        assertEquals(A, A1);
        Mockito.verify(abonneRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testUpdateAbonne() {
		 Mockito.when(abonneRepository.save(A1)).thenReturn(A1);
	      assertEquals(abonneService.updateAbonne(A1),A1);
	       Mockito.verify(abonneRepository, Mockito.times(1)).save(A1);
	}

	@Test
	public void testDeleteAbonne() {
		Mockito.when(abonneRepository.getOne(1L)).thenReturn(A1);
		abonneService.deleteAbonne(1L);;
        Mockito.verify(abonneRepository, Mockito.times(1)).deleteById(1L); 
	}

	@Test
	public void testActivateAbonne() {
		Mockito.when(abonneRepository.getOne(1L)).thenReturn(A1);
        abonneService.activateAbonne(1L);   
        assertEquals(true, A1.getIsActivated());
       Mockito.verify(abonneRepository, Mockito.times(1)).save(A1);
	}

	@Test
	public void testDesactivateAbonne() {
		 Mockito.when(abonneRepository.getOne(1L)).thenReturn(A1);
	      abonneService.desactivateAbonne(1L); 
	      Mockito.verify(abonneRepository, Mockito.times(1)).save(A1);
	}

	@Test
	public void testGetAbonnes() {
		when(abonneRepository.findAll()).thenReturn(Stream.of(A1, A2).collect(Collectors.toList()));
        assertEquals(abonneService.getAbonnes().size(), 2);
        Mockito.verify(abonneRepository, Mockito.times(1)).findAll();
	}

}
