package co.com.mercadolibre.mutant.service;

import co.com.mercadolibre.mutant.model.dto.Dna;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DnaServiceTest {

    @InjectMocks
    private DnaService dnaService;

    @Mock
    private SequenceService sequenceService;

    @Mock
    private StatisticService statisticService;

    private Dna dna;

    @Before
    public void setUp() {

        List<String> dnas = new ArrayList<>();
        dnas.add("CTCTGA");
        dnas.add("ACTTTA");
        dnas.add("CTCTGT");
        dnas.add("CAGCTT");
        dnas.add("TTGAAG");
        dnas.add("TCAAGT");

        dna = new Dna();
        dna.setDna(dnas);

    }

    @Test
    public void dnaMutantTrueHorizontalTest() {
        when(sequenceService.horizontalDna(any())).thenReturn(2);

        Assert.assertEquals(true, dnaService.dnaMutant(dna));
    }

    @Test
    public void dnaMutantTrueVerticalTest() {
        when(sequenceService.verticalDna(any())).thenReturn(2);

        Assert.assertEquals(true, dnaService.dnaMutant(dna));
    }

    @Test
    public void dnaMutantDiagonalTest() {
        when(sequenceService.horizontalDna(any())).thenReturn(0);
        when(sequenceService.verticalDna(any())).thenReturn(0);
        when(sequenceService.diagonalDown(any())).thenReturn(2);

        Assert.assertEquals(true, dnaService.dnaMutant(dna));
    }


    @Test
    public void dnaMutantDiagonalUpTest() {
        when(sequenceService.horizontalDna(any())).thenReturn(0);
        when(sequenceService.verticalDna(any())).thenReturn(0);
        when(sequenceService.diagonalDown(any())).thenReturn(1);
        when(sequenceService.diagonalUp(any())).thenReturn(1);

        Assert.assertEquals(true, dnaService.dnaMutant(dna));
    }

    @Test
    public void dnaMutantFalseTest() {
        when(sequenceService.horizontalDna(any())).thenReturn(0);
        when(sequenceService.verticalDna(any())).thenReturn(0);
        when(sequenceService.diagonalDown(any())).thenReturn(0);
        when(sequenceService.diagonalUp(any())).thenReturn(1);

        Assert.assertEquals(false, dnaService.dnaMutant(dna));
    }

}
