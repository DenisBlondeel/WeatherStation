package me.denisblondeel.repository;

import me.denisblondeel.domain.Measurement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MeasurementRepository extends MongoRepository<Measurement, Long>
{
    Measurement findTopByOrderByIdDesc();

    List<Measurement> findTop12ByOrderByIdDesc();

    Measurement findFirstByTimestampBetweenOrderByTemperature(LocalDateTime from, LocalDateTime to);

    Measurement findFirstByTimestampBetweenOrderByTemperatureDesc(LocalDateTime from, LocalDateTime to);

    Measurement findFirstByTimestampBetweenOrderByPressureDesc(LocalDateTime from, LocalDateTime to);

    Measurement findFirstByTimestampBetweenOrderByPressure(LocalDateTime from, LocalDateTime to);

    Measurement findFirstByTimestampBetweenOrderByHumidityDesc(LocalDateTime from, LocalDateTime to);

    Measurement findFirstByTimestampBetweenOrderByHumidity(LocalDateTime from, LocalDateTime to);




}
