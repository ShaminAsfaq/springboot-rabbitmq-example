package com.tuc.example.springbootrabbitmqexample.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order  implements Serializable {
    private String orderId;
    private String name;
    private int quantity;
    private double price;
}
