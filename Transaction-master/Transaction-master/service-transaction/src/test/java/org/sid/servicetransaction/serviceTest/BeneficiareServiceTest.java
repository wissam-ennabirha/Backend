package org.sid.servicetransaction.serviceTest;

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
import org.sid.servicetransaction.dao.BeneficiareRepository;
import org.sid.servicetransaction.entities.Abonne;
import org.sid.servicetransaction.entities.Beneficiare;
import org.sid.servicetransaction.service.BeneficiareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BeneficiareServiceTest {
	public static Beneficiare B1;
	public static Beneficiare B2;
	public static Abonne A1;
	@Autowired
	private  BeneficiareService beneficaireService;
	@MockBean
	private BeneficiareRepository benificaireRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListBeneficiare() {
		when(benificaireRepository.findAll()).thenReturn(Stream.of(B1,B2).collect(Collectors.toList()));
        assertEquals(beneficaireService.listBeneficiare().size(), 2);
        Mockito.verify(benificaireRepository, Mockito.times(1)).findAll();
	}

	@Test
	public void testListBeneficiareByAbonne() {
		when(benificaireRepository.findByAbonne(A1)).thenReturn(Stream.of(B1,B2).collect(Collectors.toList()));
        assertEquals(beneficaireService.listBeneficiareByAbonne(A1).size(), 2);
        Mockito.verify(benificaireRepository, Mockito.times(1)).findByAbonne(A1);
	}

	@Test
	public void testGetBeneficiare() {
		  Mockito.when(benificaireRepository.getOne(1L)).thenReturn(B1);
	        Beneficiare A = beneficaireService.getBeneficiare(1L);
	        assertEquals(A, B1);
	        Mockito.verify(benificaireRepository, Mockito.times(1)).getOne(1L);
	}

	@Test
	public void testSaveBeneficiare() {
		 Mockito.when(benificaireRepository.save(B1)).thenReturn(B1);
	      assertEquals(beneficaireService.saveBeneficiare(B1),B1);
	       Mockito.verify(benificaireRepository, Mockito.times(1)).save(B1);
	}

	@Test
	public void testDeleteBeneficiare() {
		Mockito.when(benificaireRepository.getOne(1L)).thenReturn(B1);
		beneficaireService.deleteBeneficiare(1L);;
        Mockito.verify(benificaireRepository, Mockito.times(1)).delete(benificaireRepository.getOne(1L)); 
	}

}
