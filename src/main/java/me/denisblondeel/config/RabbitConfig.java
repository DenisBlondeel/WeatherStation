package me.denisblondeel.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue weatherReport() {
        return new Queue("weatherReport", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("amq.topic");
    }

    @Bean
    Binding financeBinding(Queue weatherReport, TopicExchange exchange) {
        return BindingBuilder.bind(weatherReport).to(exchange).with("#");
    }


}
