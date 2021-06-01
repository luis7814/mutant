package co.com.mercadolibre.mutant.controller;

import co.com.mercadolibre.mutant.model.dto.Dna;
import co.com.mercadolibre.mutant.service.DnaService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DnaControllerTest {

    @InjectMocks
    private DnaController dnaController;

    @Mock
    private DnaService dnaService;

    private Dna dna;

    @Before
    public void setUp() {
        dna = new Dna();
    }


    @Test
    public void mutantTrueTest() {

        when(dnaService.dnaMutant(any(Dna.class))).thenReturn(true);
        ResponseEntity<Boolean> response = dnaController.mutant(dna);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    public void mutantFalseTest() {

        when(dnaService.dnaMutant(any(Dna.class))).thenReturn(false);
        ResponseEntity<Boolean> response = dnaController.mutant(dna);
        Assert.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }
}
