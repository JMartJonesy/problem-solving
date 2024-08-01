/**
198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
**/

public class HouseRobber {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		for(int i = nums.length - 1; i >= 0; --i) {
			int oneAway = 0;
			int twoAway = 0;
			if(i + 1 < nums.length) {
				oneAway = dp[i + 1];
			}
			if(i + 2 < nums.length) {
				twoAway = dp[i + 2];
			}
			dp[i] = Math.max(oneAway, nums[i] + twoAway);
		}

		return dp[0];
	}
}
