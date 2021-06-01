package co.com.mercadolibre.mutant.controller;

import co.com.mercadolibre.mutant.model.dto.StatisticResponse;
import co.com.mercadolibre.mutant.service.StatisticService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticControllerTest {

    @InjectMocks
    private StatisticController statisticController;

    @Mock
    private StatisticService statisticService;


    @Test
    public void statsTest() {

        when(statisticService.stats()).thenReturn(new StatisticResponse());
        ResponseEntity<StatisticResponse> response = statisticController.get();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
