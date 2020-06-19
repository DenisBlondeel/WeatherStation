package me.denisblondeel.service;

import me.denisblondeel.domain.MeasurementDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface MeasurementService {

    void addMeasurement(MeasurementDTO measurementDTO);

    MeasurementDTO getLastMeasurement();

    List<MeasurementDTO> getLast12Measurements();

    MeasurementDTO getMinimumTemp(LocalDateTime period);

    MeasurementDTO getMaximumTemp(LocalDateTime period);

    MeasurementDTO getMinimumHumidity(LocalDateTime period);

    MeasurementDTO getMinimumPressure(LocalDateTime period);

    MeasurementDTO getMaximumHumidity(LocalDateTime period);

    MeasurementDTO getMaximumPressure(LocalDateTime period);
}
