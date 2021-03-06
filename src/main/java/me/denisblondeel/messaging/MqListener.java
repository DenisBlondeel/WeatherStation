package me.denisblondeel.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.domain.MeasurementDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RabbitListener(queues = "weatherReport")
    public void processMessage(byte[] content)
    {
        try
        {
            System.out.println(new String(content));
            service.addMeasurement(mapper.readValue(new String(content), MeasurementDTO.class));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
