package com.rewards.customerrewards.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class Customer {

    @Id
    private Long customerId;
    private String customerName;

}
