package com.rewards.customerrewards.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="transactions")
@Data
public class Transaction {

    @Id
    private Long transactionId;
    private Long customerId;
    private Double amount;
    private LocalDate transactionDate;
}
