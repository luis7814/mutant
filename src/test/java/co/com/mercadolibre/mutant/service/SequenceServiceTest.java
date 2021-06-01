package co.com.mercadolibre.mutant.service;

import co.com.mercadolibre.mutant.model.dto.Dna;
import co.com.mercadolibre.mutant.util.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SequenceServiceTest {

    @InjectMocks
    private SequenceService sequenceService;

    @Before
    public void setUp() {



    }

    @Test
    public void horizontalTest() {

        List<String> dnas = new ArrayList<>();
        dnas.add("CCCCGA");
        dnas.add("ACTTTA");
        dnas.add("CTCTGT");
        dnas.add("CAGCTT");
        dnas.add("TTGAAG");
        dnas.add("TCAAGT");

        Dna dna = new Dna();
        dna.setDna(dnas);

        Assert.assertEquals(Constants.ONE, sequenceService.horizontalDna(dna));

    }

    @Test
    public void verticalTest() {

        List<String> dnas = new ArrayList<>();
        dnas.add("CCCCGA");
        dnas.add("CACTTA");
        dnas.add("CTATGT");
        dnas.add("CAGCTT");
        dnas.add("TTGAAG");
        dnas.add("TCAAGT");

        Dna dna = new Dna();
        dna.setDna(dnas);

        Assert.assertEquals(Constants.ONE, sequenceService.verticalDna(dna));

    }

    @Test
    public void diagonalDownTest() {

        List<String> dnas = new ArrayList<>();
        dnas.add("ACCCGA");
        dnas.add("CACTTA");
        dnas.add("CTATGT");
        dnas.add("CAGATT");
        dnas.add("TTGAAG");
        dnas.add("TCAAGT");

        Dna dna = new Dna();
        dna.setDna(dnas);

        Assert.assertEquals(Constants.ONE, sequenceService.diagonalDown(matrix(dna)));

    }

    @Test
    public void diagonalUpTest() {

        List<String> dnas = new ArrayList<>();
        dnas.add("ACCCGA");
        dnas.add("CACTTA");
        dnas.add("CTACGT");
        dnas.add("CAGACT");
        dnas.add("TTGAAG");
        dnas.add("TCAAGT");

        Dna dna = new Dna();
        dna.setDna(dnas);

        Assert.assertEquals(Constants.ONE, sequenceService.diagonalUp(matrix(dna)));

    }

    private String[][] matrix(Dna dna) {

        //Se pasa a matriz para buscar secuencia en diagonal
        String[][] dnaMatrix = new String[dna.getDna().size()][dna.getDna().size()];

        for(int a = Constants.ZERO; a < dna.getDna().size(); a++) {
            for(int b = Constants.ZERO; b < dna.getDna().size(); b++) {
                dnaMatrix[a][b] = String.valueOf(dna.getDna().get(a).charAt(b));
            }
        }

        return dnaMatrix;

    }


}
