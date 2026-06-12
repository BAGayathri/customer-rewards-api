package com.rewards.customerrewards.service;

import com.rewards.customerrewards.Entity.Customer;
import com.rewards.customerrewards.Entity.Transaction;
import com.rewards.customerrewards.dto.RewardResponseDto;
import com.rewards.customerrewards.exception.CustomerNotFoundException;
import com.rewards.customerrewards.repository.CustomerRepository;
import com.rewards.customerrewards.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RewardService {

    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    @Value("${reward.months}")
    private int rewardMonths;

    public RewardService(CustomerRepository customerRepository,TransactionRepository transactionRepository)
    {
        this.customerRepository=customerRepository;
        this.transactionRepository=transactionRepository;
    }

    public int calculateRewardPoints(double amount)
    {
        if(amount<=50)
            return 0;
        if(amount<=100)
            return (int)(amount-50);
        return 50+(int)((amount-100)*2);
    }

    public RewardResponseDto getRewardsByCustomer(Long customerId)
    {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer not found: "+customerId));
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(rewardMonths);
        List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId,startDate,endDate);
        Map<String,Integer> monthlyRewards = new HashMap<>();
        int totalRewards = 0;
        for(Transaction transaction:transactions)
        {
            int rewardPoints = calculateRewardPoints(transaction.getAmount());
            String month = transaction.getTransactionDate().getMonth().toString();
            monthlyRewards.merge(month,rewardPoints,Integer::sum);
            totalRewards+=rewardPoints;
        }

        RewardResponseDto response = new RewardResponseDto();

        response.setCustomerId(customer.getCustomerId());
        response.setCustomerName(customer.getCustomerName());
        response.setMonthlyRewards(monthlyRewards);
        response.setTotalRewards(totalRewards);
        return response;
    }

    public List<RewardResponseDto> getAllCustomerRewards()
    {
        return customerRepository.findAll().stream().map(customer->getRewardsByCustomer(customer.getCustomerId())).toList();
    }
}
