package me.denisblondeel.repository;

import me.denisblondeel.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long>
{
    Measurement findTopByOrderByIdDesc();
}
