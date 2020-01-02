package com.example.demo.servicesTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.example.demo.Repositories.OffreRepository;
import com.example.demo.entities.Offre;
import com.example.demo.services.OffreService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OffreServiceImpTest {
	public static Offre O1;
    public static Offre O2;
    public static Offre O3;
    @Autowired
	private OffreService offreService;
	@MockBean
	private OffreRepository offreRepository;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Date d=new Date();
		SimpleDateFormat  Formatter = new SimpleDateFormat("dd-MM-yy");
		O1= new Offre(1L, Formatter.parse("11-06-2019"), Formatter.parse("11-06-2020"), true, true);
		O2=new Offre(2L, Formatter.parse("11-06-2019"), Formatter.parse("11-06-2020"), false, false);
		O3=new Offre(3L, Formatter.parse("11-06-2019"),Formatter.parse("11-06-2020"), true, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOffre() {
		 Mockito.when(offreRepository.getOne(1L)).thenReturn(O1);
	        Offre C = offreService.getOffre(1L);
	        assertEquals(C, O1);
	        Mockito.verify(offreRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testGetOffres() {
	        when(offreRepository.findAll()).thenReturn(Stream.of(O1, O2).collect(Collectors.toList()));
	        assertEquals(offreService.getOffres().size(), 2);
	        Mockito.verify(offreRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void testActivateEtatOffre() {
		Mockito.when(offreRepository.getOne(1L)).thenReturn(O1);
		offreService.activateEtatOffre(1);  
		Mockito.verify(offreRepository, Mockito.times(1)).save(O1);
	}

	@Test
	public void testChoix() {
		Mockito.when(offreRepository.getOne(1L)).thenReturn(O1);
		offreService.Choix(1L);   
       Mockito.verify(offreRepository, Mockito.times(1)).save(O1);
	}

	@Test
	public void testDesaactivateEtatOffre() {
		Mockito.when(offreRepository.getOne(1L)).thenReturn(O1);
		offreService.desaactivateEtatOffre(1L);   
       Mockito.verify(offreRepository, Mockito.times(1)).save(O1);
	}

	@Test
	public void testDesactiveChoix() {
		Mockito.when(offreRepository.getOne(1L)).thenReturn(O1);
		offreService.desactiveChoix(1L);   
       Mockito.verify(offreRepository, Mockito.times(1)).save(O1);
	}

	@Test
	public void testSaveOffre() {
		Mockito.when(offreRepository.save(O1)).thenReturn(O1);
	      assertEquals(offreService.saveOffre(O1),O1);
	       Mockito.verify(offreRepository, Mockito.times(1)).save(O1);
		
	}

	@Test
	public void testUpdateAgence() {
		Mockito.when(offreRepository.save(O1)).thenReturn(O1);
	      assertEquals(offreService.updateAgence(O1),O1);
	       Mockito.verify(offreRepository, Mockito.times(1)).save(O1);
	}

}
