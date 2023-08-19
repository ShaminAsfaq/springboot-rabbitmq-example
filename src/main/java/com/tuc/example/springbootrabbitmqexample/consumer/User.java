package com.tuc.example.springbootrabbitmqexample.consumer;

import com.tuc.example.springbootrabbitmqexample.config.MessagingConfig;
import com.tuc.example.springbootrabbitmqexample.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@ToString
public class User {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message Received From Queue: " + orderStatus);
    }
}
