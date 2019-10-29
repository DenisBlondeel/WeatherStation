package me.denisblondeel.service.mapper;

import me.denisblondeel.domain.Measurement;
import me.denisblondeel.service.dto.MeasurementDTO;

import java.time.LocalDateTime;

public class MeasurementMapper {

    public static Measurement toEntity(MeasurementDTO dto)
    {
        Measurement entity = new Measurement();
        entity.setTemperature(dto.getTemperature());
        entity.setPressure(dto.getPressure());
        entity.setHumidity(dto.getHumidity());
        entity.setTimestamp(LocalDateTime.now());
        return entity;
    }

    public static MeasurementDTO toDto(Measurement entity)
    {
        MeasurementDTO dto = new MeasurementDTO();
        dto.setHumidity(entity.getHumidity());
        dto.setPressure(entity.getPressure());
        dto.setTemperature(entity.getTemperature());
        dto.setTimestamp(entity.getTimestamp());
        return dto;
    }
}
