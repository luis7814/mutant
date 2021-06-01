package co.com.mercadolibre.mutant.service;

import co.com.mercadolibre.mutant.model.Statistic;
import co.com.mercadolibre.mutant.model.dto.StatisticResponse;
import co.com.mercadolibre.mutant.repository.StatisticRepository;
import co.com.mercadolibre.mutant.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    private int sumMutant = 0;
    private int sumHuman = 0;


    /**
     * Se encarga de registrar la información del adn, indicando si es humano o mutante
     *
     * @return
     * @see boolean
     */
    public void add(boolean result) {

        Statistic statistic = new Statistic();
        statistic.setId(String.valueOf(System.currentTimeMillis()));

        if(result) {
            statistic.setMutant(Constants.ONE);
            statistic.setHuman(Constants.ZERO);
        }else {
            statistic.setMutant(Constants.ZERO);
            statistic.setHuman(Constants.ONE);
        }
        statisticRepository.save(statistic);

    }


    /**
     * Se encarga de consultar todos los registros de la tabla para sumarlos y mostrarlos en pantalla
     *
     * @return {@link StatisticResponse}
     * @see StatisticResponse
     */
    public StatisticResponse stats() {

        List<Statistic> statistics = statisticRepository.findAll();

        statistics.forEach((value -> {
            sumHuman = sumHuman + value.getHuman();
            sumMutant = sumMutant + value.getMutant();
        }));

        StatisticResponse statisticResponse = new StatisticResponse();
        statisticResponse.setCountMutantDna(sumMutant);
        statisticResponse.setCountHumanDna(sumHuman);
        statisticResponse.setRatio((sumHuman + sumMutant) / 2);

        return statisticResponse;


    }


}
