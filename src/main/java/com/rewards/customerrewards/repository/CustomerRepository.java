package com.rewards.customerrewards.repository;

import com.rewards.customerrewards.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
