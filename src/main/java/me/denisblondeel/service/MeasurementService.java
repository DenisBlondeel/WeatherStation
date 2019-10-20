package me.denisblondeel.service;

import me.denisblondeel.domain.Measurement;
import me.denisblondeel.service.dto.MeasurementDTO;

public interface MeasurementService {

    MeasurementDTO getLastMeasurement();

    void addMeasurement(MeasurementDTO measurementDTO);



}
