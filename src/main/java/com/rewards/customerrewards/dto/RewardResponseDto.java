package com.rewards.customerrewards.dto;

import lombok.Data;

import java.util.Map;

@Data
public class RewardResponseDto {

    private Long customerId;
    private String customerName;
    private Map<String,Integer> monthlyRewards;
    private Integer totalRewards;
}
