package com.datta.tvaritfinal.repository;

import com.datta.tvaritfinal.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository
        extends JpaRepository<CustomerOrder, Long> {

    List<CustomerOrder> findByCustomerCustomerId(Long customerId);

}