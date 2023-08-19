package com.tuc.example.springbootrabbitmqexample.publisher;

import com.tuc.example.springbootrabbitmqexample.config.MessagingConfig;
import com.tuc.example.springbootrabbitmqexample.dto.Order;
import com.tuc.example.springbootrabbitmqexample.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OrderPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus = new OrderStatus(order, "PROCESSING", "Order Placed Successfully in " + restaurantName);
        //  Whatever happens in Service/Repository etc.
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);

        return "Order Successful.";
    }

    @GetMapping("/status")
    public String status() {
        return "TESTING";
    }
}
