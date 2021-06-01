package co.com.mercadolibre.mutant.model.dto;

import lombok.Data;

@Data
public class StatisticResponse {

    private int countMutantDna;
    private int countHumanDna;
    private int ratio;

}
