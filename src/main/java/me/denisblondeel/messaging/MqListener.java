package me.denisblondeel.messaging;

import me.denisblondeel.service.MeasurementService;
import me.denisblondeel.service.dto.MeasurementDTO;
import me.denisblondeel.service.mapper.MeasurementMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class MqListener {

    public MqListener()
    {
        System.out.println("listner on");
    }

    @Autowired
    private MeasurementService service;

 /*   @RabbitListener(queues = "weather_report")
    public void processMessage(MeasurementDTO content)
    {
        //service.addMeasurement(content);
        System.out.println("DTOobj " + content);
        //System.out.println(MeasurementMapper.toEntity(content));
    }*/

    @RabbitListener(queues = "weather_report")
    public void processMessage(String content) {
        System.out.println(content);
    }

}
