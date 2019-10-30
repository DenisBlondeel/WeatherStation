package me.denisblondeel.service.impl;

import me.denisblondeel.domain.Measurement;
import me.denisblondeel.repository.MeasurementRepository;
import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import me.denisblondeel.service.mapper.MeasurementMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public MeasurementDTO getMinimumTemp(LocalDateTime period)
    {
        return MeasurementMapper.toDto(repository.findFirstByTimestampBetweenOrderByTemperature(period, LocalDateTime.now()));
    }

    @Override
    public MeasurementDTO getMaximumTemp(LocalDateTime period)
    {
        return MeasurementMapper.toDto(repository.findFirstByTimestampBetweenOrderByTemperatureDesc(period, LocalDateTime.now()));
    }

    @Override
    public MeasurementDTO getMinimumHumidity(LocalDateTime period)
    {
        return MeasurementMapper.toDto(repository.findFirstByTimestampBetweenOrderByHumidityDesc(period, LocalDateTime.now()));
    }

    @Override
    public MeasurementDTO getMinimumPressure(LocalDateTime period)
    {
        return MeasurementMapper.toDto(repository.findFirstByTimestampBetweenOrderByPressureDesc(period, LocalDateTime.now()));
    }

    @Override
    public MeasurementDTO getMaximumHumidity(LocalDateTime period)
    {
        return MeasurementMapper.toDto(repository.findFirstByTimestampBetweenOrderByPressure(period, LocalDateTime.now()));
    }

    @Override
    public MeasurementDTO getMaximumPressure(LocalDateTime period)
    {
        return MeasurementMapper.toDto(repository.findFirstByTimestampBetweenOrderByHumidity(period, LocalDateTime.now()));
    }
}
