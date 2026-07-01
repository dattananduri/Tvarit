package com.datta.tvaritfinal.repository;

import com.datta.tvaritfinal.entity.Customer;
import com.datta.tvaritfinal.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByCustomerEmail(String email);
}
