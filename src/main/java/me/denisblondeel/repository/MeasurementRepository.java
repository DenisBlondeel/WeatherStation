package me.denisblondeel.repository;

import me.denisblondeel.domain.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MeasurementRepository extends MongoRepository<Measurement, Long>
{
    Measurement findTopByOrderByIdDesc();

    List<Measurement> findTop12ByOrderByIdDesc();

}
