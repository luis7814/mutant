package co.com.mercadolibre.mutant.controller;

import co.com.mercadolibre.mutant.model.dto.StatisticResponse;
import co.com.mercadolibre.mutant.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/stats")
    public ResponseEntity<StatisticResponse> get() {
        return new ResponseEntity<>(statisticService.stats(), HttpStatus.OK);
    }
}
