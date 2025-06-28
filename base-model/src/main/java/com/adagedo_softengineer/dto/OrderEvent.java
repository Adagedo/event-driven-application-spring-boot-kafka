package com.adagedo_softengineer.dto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {

    private String message;
    private String status;
    private Order order;
}
