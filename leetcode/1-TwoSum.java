/**
1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
**/
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> remainders = new HashMap<>();
		for(int i = 0; i < nums.length; ++i) {
			int remainder = target - nums[i];
			if(remainders.containsKey(remainder)) {
				return new int[] {remainders.get(remainder), i};
			} else {
				remainders.put(nums[i], i);
			}
		}

		return new int[2];
	}
}
