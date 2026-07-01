package com.datta.tvaritfinal.controller;

import com.datta.tvaritfinal.dto.CustomerLoginRequest;
import com.datta.tvaritfinal.entity.Customer;
import com.datta.tvaritfinal.entity.CustomerOrder;
import com.datta.tvaritfinal.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }


    @GetMapping("/profile/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return service.getCustomer(id);
    }

    @PostMapping("/login")
    public Customer loginCustomer(@RequestBody CustomerLoginRequest loginRequest){
        return service.loginCustomer(loginRequest);
    }

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer){
        return service.registerCustomer(customer);
    }


    @PutMapping("/profile/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer)
    {
        return service.updateCustomer(id, customer);
    }

    @GetMapping("/{id}/orders")
    public List<CustomerOrder> getOrders(
            @PathVariable Long id)
    {
        return service.getOrders(id);
    }
}
