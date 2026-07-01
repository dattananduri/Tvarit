package com.datta.tvaritfinal.service;


import com.datta.tvaritfinal.dto.CustomerLoginRequest;
import com.datta.tvaritfinal.entity.Customer;
import com.datta.tvaritfinal.entity.CustomerOrder;
import com.datta.tvaritfinal.repository.CustomerRepository;
import com.datta.tvaritfinal.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final OrderRepository orderRepository;

    public CustomerService(CustomerRepository repository,
                           OrderRepository orderRepository)
    {
        this.repository = repository;
        this.orderRepository = orderRepository;
    }

    public Customer getCustomer(Long id){
        return repository.findById(id).orElse(null);
    }

    public Customer loginCustomer(CustomerLoginRequest loginRequest){
        Customer customer =
                repository.findByCustomerEmail(
                        loginRequest.getEmail());

        if(customer == null){
            return null;
        }

        if(customer.getPassword()
                .equals(loginRequest.getPassword()))
        {
            return customer;
        }
        return null;
    }

    public Customer registerCustomer(Customer customer){
        return repository.save(customer);
    }

    public Customer updateCustomer(Long id,
                                   Customer customer)
    {
        Customer existingCustomer =
                repository.findById(id)
                        .orElse(null);

        if(existingCustomer == null)
        {
            return null;
        }

        if(customer.getCustomerName() != null)
        {
            existingCustomer.setCustomerName(
                    customer.getCustomerName());
        }

        if(customer.getCustomerEmail() != null)
        {
            existingCustomer.setCustomerEmail(
                    customer.getCustomerEmail());
        }

        if(customer.getCustomerPhoneNumber() != null)
        {
            existingCustomer.setCustomerPhoneNumber(
                    customer.getCustomerPhoneNumber());
        }

        if(customer.getCustomerAddress() != null)
        {
            existingCustomer.setCustomerAddress(
                    customer.getCustomerAddress());
        }

        return repository.save(existingCustomer);
    }

    public List<CustomerOrder> getOrders(Long customerId)
    {
        return orderRepository.findByCustomerCustomerId(customerId);
    }

}
