package me.denisblondeel.service.mapper;

import me.denisblondeel.domain.Measurement;
import me.denisblondeel.service.dto.MeasurementDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MeasurementMapper {

    public static Measurement toEntity(MeasurementDTO dto)
    {
        Measurement entity = new Measurement();
        entity.setTemperature(dto.getTemperature());
        entity.setPressure(dto.getPressure());
        entity.setHumidity(dto.getHumidity());
        entity.setTimestamp(LocalDateTime.now());
        entity.setRain(dto.getRain());
        entity.setWind(dto.getWind());
        return entity;
    }

    public static MeasurementDTO toDto(Measurement entity)
    {
        MeasurementDTO dto = new MeasurementDTO();
        dto.setHumidity(entity.getHumidity());
        dto.setPressure(entity.getPressure());
        dto.setTemperature(entity.getTemperature());
        dto.setTimestamp(entity.getTimestamp());
        dto.setRain(entity.getRain());
        dto.setWind(entity.getWind());
        return dto;
    }
}
