package co.com.mercadolibre.mutant.controller;

import co.com.mercadolibre.mutant.model.dto.Dna;
import co.com.mercadolibre.mutant.service.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @PostMapping("/mutant")
    public ResponseEntity<Boolean> mutant(@RequestBody Dna dna) {

        boolean response = dnaService.dnaMutant(dna);

        if(response) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }
    }
}
