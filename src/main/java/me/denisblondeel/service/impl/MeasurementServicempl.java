package me.denisblondeel.service.impl;

import me.denisblondeel.domain.Measurement;
import me.denisblondeel.repository.MeasurementRepository;
import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import me.denisblondeel.service.mapper.MeasurementMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementServicempl implements MeasurementService {

    private final MeasurementRepository repository;

    public MeasurementServicempl(MeasurementRepository repository)
    {
        this.repository = repository;
    }

    public MeasurementDTO getLastMeasurement()
    {
        Measurement m = repository.findTopByOrderByIdDesc();
        return MeasurementMapper.toDto(m);
    }

    public void addMeasurement(MeasurementDTO measurementDTO)
    {
        repository.save(MeasurementMapper.toEntity(measurementDTO));
    }
}
