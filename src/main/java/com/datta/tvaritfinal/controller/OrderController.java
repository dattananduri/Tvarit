package com.datta.tvaritfinal.controller;

import com.datta.tvaritfinal.entity.CustomerOrder;
import com.datta.tvaritfinal.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service)
    {
        this.service = service;
    }

    @PostMapping
    public CustomerOrder createOrder(
            @RequestBody CustomerOrder customerOrder) {

        return service.createOrder(customerOrder);
    }

    @GetMapping("/{id}")
    public CustomerOrder getOrder(
            @PathVariable Long id) {

        return service.getOrder(id);
    }

    @PutMapping("/{id}/{status}")
    public CustomerOrder updateOrderStatus(
            @PathVariable Long id,
            @PathVariable String status) {

        return service.updateOrderStatus(
                id,
                status);
    }

    @PutMapping("/{orderId}/accept/{partnerId}")
    public CustomerOrder acceptOrder(
            @PathVariable Long orderId,
            @PathVariable Long partnerId)
    {
        return service.acceptOrder(orderId, partnerId);
    }
}