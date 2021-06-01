package co.com.mercadolibre.mutant.repository;

import co.com.mercadolibre.mutant.model.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface StatisticRepository extends MongoRepository<Statistic, String> {


}
