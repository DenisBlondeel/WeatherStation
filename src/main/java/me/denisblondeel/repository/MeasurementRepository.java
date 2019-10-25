package me.denisblondeel.repository;

import me.denisblondeel.domain.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeasurementRepository extends MongoRepository<Measurement, Long>
{
    Measurement findTopByOrderByIdDesc();
}
