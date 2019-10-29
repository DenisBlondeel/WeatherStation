package me.denisblondeel.service;

import me.denisblondeel.service.dto.MeasurementDTO;

import java.util.List;

public interface MeasurementService {

    MeasurementDTO getLastMeasurement();

    void addMeasurement(MeasurementDTO measurementDTO);

    List<MeasurementDTO> getLast12Measurements();


    String getMinimumTempToday();

    String getMinimumTempMonth();

    String getMinimumTempYear();

    String getMinimumHumidityYear();

    String getMinimumPressureYear();
}
