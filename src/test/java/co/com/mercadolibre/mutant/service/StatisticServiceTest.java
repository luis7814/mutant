package co.com.mercadolibre.mutant.service;

import co.com.mercadolibre.mutant.model.Statistic;
import co.com.mercadolibre.mutant.model.dto.StatisticResponse;
import co.com.mercadolibre.mutant.repository.StatisticRepository;
import co.com.mercadolibre.mutant.util.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticServiceTest {

    @InjectMocks
    private StatisticService statisticService;

    @Mock
    private StatisticRepository statisticRepository;

    @Test
    public void addTest() {
        statisticService.add(true);
    }

    @Test
    public void addFalseTest() {
        statisticService.add(false);
    }

    @Test
    public void findAllTest() {

        List<Statistic> statistics = new ArrayList<>();
        Statistic statistic = new Statistic();
        statistic.setHuman(1);
        statistic.setMutant(0);
        statistics.add(statistic);

        when(statisticRepository.findAll()).thenReturn(statistics);
        StatisticResponse statisticResponse = statisticService.stats();

        Assert.assertNotNull(statisticResponse);
        Assert.assertEquals(Constants.ONE, statisticResponse.getCountHumanDna());

    }

    @Test
    public void findAllNotNullTest() {
        when(statisticRepository.findAll()).thenReturn(new ArrayList<>());

        Assert.assertNotNull(statisticService.stats());
    }

}
