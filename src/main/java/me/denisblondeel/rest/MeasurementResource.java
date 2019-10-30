package me.denisblondeel.rest;

import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MeasurementResource{


    @Autowired
    private MeasurementService service;


    @RequestMapping(value = "/measurements", method = RequestMethod.POST)
    public void ingestData(@RequestBody MeasurementDTO measurementDTO)
    {
        service.addMeasurement(measurementDTO);
    }

    @RequestMapping(value = "/measurements", method = RequestMethod.GET)
    public MeasurementDTO overview()
    {
        return service.getLastMeasurement();
    }

    @RequestMapping(value = "/lasthour", method = RequestMethod.GET)
    public List<MeasurementDTO> lastHour()
    {
        return service.getLast12Measurements();
    }

    @RequestMapping(value= "/minimum_temp_today", method = RequestMethod.GET)
    public MeasurementDTO minimumTempToday()
    {
        return service.getMinimumTemp(LocalDateTime.now().minusDays(1));
    }

    @RequestMapping(value= "/minimum_temp_month", method = RequestMethod.GET)
    public MeasurementDTO minimumTempMonth()
    {
        return service.getMinimumTemp(LocalDateTime.now().minusMonths(1));
    }

    @RequestMapping(value= "/minimum_temp_year", method = RequestMethod.GET)
    public MeasurementDTO minimumTempYear()
    {
        return service.getMinimumTemp(LocalDateTime.now().minusYears(1));
    }

    @RequestMapping(value= "/maximum_temp_today", method = RequestMethod.GET)
    public MeasurementDTO maximumTempDay()
    {
        return service.getMaximumTemp(LocalDateTime.now().minusDays(1));
    }

    @RequestMapping(value= "/maximum_temp_month", method = RequestMethod.GET)
    public MeasurementDTO maximumTempMonth()
    {
        return service.getMaximumTemp(LocalDateTime.now().minusMonths(1));
    }

    @RequestMapping(value= "/maximum_temp_year", method = RequestMethod.GET)
    public MeasurementDTO maximumTempYear()
    {
        return service.getMaximumTemp(LocalDateTime.now().minusYears(1));
    }

    @RequestMapping(value= "/minimum_hum_year", method = RequestMethod.GET)
    public MeasurementDTO minimumHumYear()
    {
        return service.getMinimumHumidity(LocalDateTime.now().minusYears(1));
    }

    @RequestMapping(value= "/minimum_press_year", method = RequestMethod.GET)
    public MeasurementDTO minimumPressYear()
    {
        return service.getMinimumPressure(LocalDateTime.now().minusYears(1));
    }

    @RequestMapping(value= "/maximum_hum_year", method = RequestMethod.GET)
    public MeasurementDTO maximumHumYear()
    {
        return service.getMaximumHumidity(LocalDateTime.now().minusYears(1));
    }

    @RequestMapping(value= "/maximum_press_year", method = RequestMethod.GET)
    public MeasurementDTO maximumPressYear()
    {
        return service.getMaximumPressure(LocalDateTime.now().minusYears(1));
    }


    
}
