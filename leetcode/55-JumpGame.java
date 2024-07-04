/**
55. Jump Game
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Complexity Analysis

    Time complexity : O(n).
    We are doing a single pass through the nums array, hence n steps, where n is the length of array nums.

    Space complexity : O(1).
    We are not using any extra memory.

**/
public class JumpGame{
	public boolean canJump(int[] nums) {
		int currIndex = 0;
		while(nums[currIndex] != 0) {
			int maxJump = 0:
			int maxIndex = 0;
			for(int i = 1; i <= nums[currIndex]; ++i) {
				if(currIndex + i >= nums.length -1) {
					return true;
				}

				if(maxJump <= i + nums[currIndex + i]) {
					maxJump = i + nums[currIndex + i];
					maxIndex = currIndex + i;
				}
			}
			currIndex = maxIndex;
		}
		
		return currIndex >= nums.length - 1;
	}

	public boolean canJumpBetter(int[] nums) {
		int lastPos = nums.length -1;
		for(int i = nums.length - 1; i >= 0; --i) {
			if(i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}

		return lastPost == 0;
	}
}
