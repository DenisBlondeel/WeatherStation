package me.denisblondeel.service.impl;

import me.denisblondeel.domain.Measurement;
import me.denisblondeel.repository.MeasurementRepository;
import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import me.denisblondeel.service.mapper.MeasurementMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeasurementServicempl implements MeasurementService {

    private final MeasurementRepository repository;

    public MeasurementServicempl(MeasurementRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public MeasurementDTO getLastMeasurement()
    {
        Measurement m = repository.findTopByOrderByIdDesc();
        return MeasurementMapper.toDto(m);
    }

    @Override
    public void addMeasurement(MeasurementDTO measurementDTO)
    {
        repository.save(MeasurementMapper.toEntity(measurementDTO));
    }

    @Override
    public List<MeasurementDTO> getLast12Measurements()
    {
        return repository.findTop12ByOrderByIdDesc()
                         .stream()
                         .map(MeasurementMapper::toDto)
                         .collect(Collectors.toList());
    }

    @Override
    public String getMinimumTempToday()
    {
        return null;
    }

    @Override
    public String getMinimumTempMonth()
    {
        return null;
    }

    @Override
    public String getMinimumTempYear()
    {
        return null;
    }

    @Override
    public String getMinimumHumidityYear()
    {
        return null;
    }

    @Override
    public String getMinimumPressureYear()
    {
        return null;
    }
}
