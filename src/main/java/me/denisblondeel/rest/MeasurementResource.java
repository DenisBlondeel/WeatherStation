package me.denisblondeel.rest;

import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String minimumTempToday()
    {
        return service.getMinimumTempToday();
    }

    @RequestMapping(value= "/minimum_temp_month", method = RequestMethod.GET)
    public String minimumTempMonth()
    {
        return service.getMinimumTempMonth();
    }

    @RequestMapping(value= "/minimum_temp_year", method = RequestMethod.GET)
    public String minimumTempYear()
    {
        return service.getMinimumTempYear();
    }

    @RequestMapping(value= "/minimum_hum_year", method = RequestMethod.GET)
    public String minimumHumYear()
    {
        return service.getMinimumHumidityYear();
    }

    @RequestMapping(value= "/minimum_press_year", method = RequestMethod.GET)
    public String minimumPressYear()
    {
        return service.getMinimumPressureYear();
    }


    
}
