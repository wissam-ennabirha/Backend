package com.service.administration.controllerTest;

import static org.junit.Assert.assertEquals;


import java.util.Arrays;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.administration.controller.AbonneApi;
import com.service.administration.models.Abonne;
import com.service.administration.services.AbonneService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AbonneApiTest {
	public static Abonne A1;
    public static Abonne A2;
    public static Abonne A3;
    @InjectMocks
    AbonneApi  abonneControlles;
      
     @Mock
     AbonneService abonneService;

	@Before
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
        A1 =new Abonne(1L,"dd@mlk","mlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
        A2 =new Abonne(2L,"dqqd@mlk","mqqlko","sdd","123", "Ennaiha", "Wissam", "jadida hay salam", 123, "Eudiane", false,null);
       A3=new Abonne(3L, "ffff", "fff", "fff", "44543", "wissam", "frr", "rrr", 33432, "rrr", false, null);
	}

	@After
	void tearDown() throws Exception {
	}

	@Test
	void testGetAgences() {
		  Mockito.when(abonneService.getAbonnes()).thenReturn(Arrays.asList(A1, A2));
	        assertEquals(abonneControlles.getAgences().size(), 2);
	        Mockito.verify(abonneService, Mockito.times(1)).getAbonnes();
	}

}
