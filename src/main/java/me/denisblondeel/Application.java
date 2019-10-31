package me.denisblondeel;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication()
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Queue myQueue() {
        return new Queue("weather_report", false);
    }



}


