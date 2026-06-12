package com.rewards.customerrewards.controller;

import com.rewards.customerrewards.dto.RewardResponseDto;
import com.rewards.customerrewards.service.RewardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;
    public RewardController(RewardService rewardService)
    {
        this.rewardService=rewardService;
    }

    @GetMapping("/customers")
    public List<RewardResponseDto> getAllCustomerRewards()
    {
        return rewardService.getAllCustomerRewards();
    }

    @GetMapping("/customers/{customerId}")
    public RewardResponseDto getCustomerRewards(@PathVariable Long customerId)
    {
        return rewardService.getRewardsByCustomer(customerId);
    }
}
