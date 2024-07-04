/**
  238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
**/
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int zeroIndex = 0;
		int zeroCount = 0;
		int totalProduct = 1;
		int[] answer = new int[nums.length];
		for(int i = 0; i < nums.length; ++i) {
			int num = nums[i];
			if(num == 0) {
				++zeroCount;
				zeroIndex = i;
			} else {
				totalProduct = totalProduct * num;
			}
		}

		if(zeroCount == 1) {
			answer[zeroIndex] = totalProduct;
		} else if(zeroCount == 0) {
			for(int i = 0; i < nums.length; ++i) {
				answer[i] = totalProduct / nums[i];
			}
		}

		return answer;
	}
}
