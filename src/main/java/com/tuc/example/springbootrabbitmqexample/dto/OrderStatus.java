package com.tuc.example.springbootrabbitmqexample.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatus implements Serializable {
    private Order order;
    private String status;
    private String message;
}
