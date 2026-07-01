package com.datta.tvaritfinal.service;

import com.datta.tvaritfinal.entity.CustomerOrder;
import com.datta.tvaritfinal.entity.Partner;
import com.datta.tvaritfinal.repository.OrderRepository;
import com.datta.tvaritfinal.repository.PartnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final PartnerRepository partnerRepository;

    public OrderService(OrderRepository repository, PartnerRepository partnerRepository)
    {
        this.repository = repository;
        this.partnerRepository = partnerRepository;
    }

    public CustomerOrder createOrder(CustomerOrder customerOrder) {
        return repository.save(customerOrder);
    }

    public CustomerOrder getOrder(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public CustomerOrder updateOrderStatus(Long id,
                                           String status) {

        CustomerOrder customerOrder = repository.findById(id)
                .orElse(null);

        if(customerOrder == null) {
            return null;
        }

        customerOrder.setStatus(status);

        return repository.save(customerOrder);
    }

    public CustomerOrder acceptOrder(
            Long orderId,
            Long partnerId)
    {
        CustomerOrder order =
                repository.findById(orderId)
                        .orElse(null);

        Partner partner =
                partnerRepository.findById(partnerId)
                        .orElse(null);

        if(order == null || partner == null)
        {
            return null;
        }

        order.setPartner(partner);

        order.setStatus("ACCEPTED");

        return repository.save(order);
    }
}