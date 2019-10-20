package me.denisblondeel.rest;

import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
}
