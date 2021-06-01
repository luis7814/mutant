package co.com.mercadolibre.mutant.service;

import co.com.mercadolibre.mutant.model.dto.Dna;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {


    /**
     * vertical dna
     *
     * @param dna dna {@link Dna}
     * @return {@link int}
     */
    public int verticalDna(Dna dna) {

        int cont = 0;
        int response = 0;

        for(int b = 0; b < dna.getDna().size(); b++) {
            for(int a = 0; a < dna.getDna().size(); a++) {
                if(a < (dna.getDna().size() - 1)) {
                    if(dna.getDna().get(a).charAt(b) == dna.getDna().get(a + 1).charAt(b)) {
                        cont++;
                    }else {
                        cont = cont > 0 ? cont : 0;
                    }
                }
            }
            response = response + (cont > 2 ? 1 : 0);
            cont = 0;
        }


        return response;
    }


    /**
     * horizontal dna
     *
     * @param dna dna {@link Dna}
     * @return {@link int}
     */
    public int horizontalDna(Dna dna) {

        int cont = 0;
        int response = 0;

        for(int a = 0; a < dna.getDna().size(); a++) {
            for(int b = 1; b < dna.getDna().size(); b++) {
                if(dna.getDna().get(a).charAt(b-1) == dna.getDna().get(a).charAt(b)) {
                    cont++;
                }else {
                    cont = cont > 0 ? cont : 0;
                }
            }
            response = response + (cont > 2 ? 1 : 0);
            cont = 0;
        }

        return response;
    }


    public int diagonalDown(String[][] dna) {

        String valor = "";
        int cont = 0;
        int response = 0;

        for(int a = 0; a < dna.length; a++) {
            for(int b = 0; b < (dna[a].length - a); b++) {
                if(b == 0) {
                    valor = dna[a][b];
                }else {
                    if(valor.equals(dna[a+b][b])) {
                        cont++;
                        if(b == ((dna[a].length - a) - 1)) {
                            cont++;
                        }
                    }else {
                        valor = dna[a+b][b];
                        cont = cont > 0 ? cont : 0;
                    }
                }
            }
            response = response + (cont > 2 ? 1 : 0);
            cont = 0;

        }

        return response;
    }


    public int diagonalUp(String[][] dna) {

        String valor = "";
        int contRow = 0;
        int cont = 0;
        int response = 0;


        for(int a = 0; a < dna.length; a++) {
            int b = a + 1;
            contRow = 0;
            while(b < (dna[a].length - a)) {
                if(b == (a + 1)) {
                    valor = dna[0][b];
                }else {
                    if(valor.equals(dna[contRow][b])) {
                        cont++;
                        if(b == ((dna[a].length - a) - 1)) {
                            cont++;
                        }
                    }else {
                        valor = dna[contRow][b];
                        cont = cont > 0 ? cont : 0;
                    }
                }
                b++;
                contRow++;
            }
            response = response + (cont > 2 ? 1 : 0);
            cont = 0;

        }

        return response;
    }

}
