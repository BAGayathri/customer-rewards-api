package com.rewards.customerrewards;

import com.rewards.customerrewards.service.RewardService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerRewardsApiApplicationTests {

	RewardService rewardService=new RewardService(null,null);

	@Test
	void shouldReturnZeroRewardForAmountLessThan50()
	{
		assertEquals(0,rewardService.calculateRewardPoints(45));
	}

	@Test
	void shouldCalculateForReward75()
	{
		assertEquals(25,rewardService.calculateRewardPoints(75));
	}

	@Test
	void shouldCalculateForReward120()
	{
		assertEquals(90,rewardService.calculateRewardPoints(120));
	}

	@Test
	void shouldCalculateForReward750()
	{
		assertEquals(1350,rewardService.calculateRewardPoints(750));
	}



}
