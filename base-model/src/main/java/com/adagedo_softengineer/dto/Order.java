package com.adagedo_softengineer.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private String OrderId;
    private String name;
    private int quantity;
    private double price;
}
