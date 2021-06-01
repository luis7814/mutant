package co.com.mercadolibre.mutant.service;

import co.com.mercadolibre.mutant.model.dto.Dna;
import co.com.mercadolibre.mutant.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnaService {

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private StatisticService statisticService;

    /**
     * Se encarga de recorrer el adn para verificar si es mutante o humano, la secuencia se recorre horizontal, diagonal y vertical.
     * Si en caso de encontrar la secuencia mutante en alguna de las anteriores, no recorrerá las demás, ejemplo, si recorre el ADN horizontal y se evidencia que es mutante,
     * no abrá necesidad de recorrerlo diagonal y vertical.
     * Importante : Es mutante si encuentra más de una secuencia de cuatro letras iguales.
     *
     * @param dna dna {@link Dna}
     * @return {@link boolean}
     */
    public boolean dnaMutant(Dna dna) {

        boolean response = false;
        int sequence = 0;

        //Busca la secuencia en vertical
        sequence = sequenceService.verticalDna(dna);

        if(sequence < Constants.TWO) {

            //Busca la secuencia en horizontal
            sequence = sequence + sequenceService.horizontalDna(dna);
            if(sequence < Constants.TWO) {

                //Se pasa a matriz para buscar secuencia en diagonal
                String[][] dnaMatrix = new String[dna.getDna().size()][dna.getDna().size()];

                for(int a = Constants.ZERO; a < dna.getDna().size(); a++) {
                    for(int b = Constants.ZERO; b < dna.getDna().size(); b++) {
                        dnaMatrix[a][b] = String.valueOf(dna.getDna().get(a).charAt(b));
                    }
                }

                sequence = sequence + sequenceService.diagonalDown(dnaMatrix);
                if(sequence < Constants.TWO) {
                    sequence = sequence + sequenceService.diagonalUp(dnaMatrix);

                    if(sequence > Constants.ONE) {
                        response = true;
                    }
                }else {
                    response = true;
                }
            }else {
                response = true;
            }
        }else {
            response = true;
        }

        //Registra en base de datos la información, TRUE si es mutante de lo contrario false
        statisticService.add(response);

        return response;

    }



}
