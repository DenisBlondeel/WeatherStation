package me.denisblondeel.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import me.denisblondeel.service.mapper.MeasurementMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class MqListener {

    private ObjectMapper mapper;

    public MqListener()
    {
        mapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }

    @Autowired
    private MeasurementService service;

    @RabbitListener(queues = "weather_report")
    public void processMessage(String content)
    {
        try
        {
            System.out.println(content);
            service.addMeasurement(mapper.readValue(content.replaceAll(",", " "), MeasurementDTO.class));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
