package co.com.mercadolibre.mutant.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "statistic")
public class Statistic implements Serializable {

    @Id
    private String id;
    private int human;
    private int mutant;


}
