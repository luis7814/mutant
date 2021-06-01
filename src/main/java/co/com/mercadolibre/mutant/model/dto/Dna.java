package co.com.mercadolibre.mutant.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Dna implements Serializable {

    List<String> dna;

}
