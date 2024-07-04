/**
45. Jump Game II
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n

Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Let n be the length of the input array nums.

    Time complexity: O(n)

    We iterate over nums and stop at the second last element. In each step of the iteration, we make some calculations that take constant time. Therefore, the overall time complexity is O(n).

    Space complexity: O(1)

    In the iteration, we only need to update three variables, curEnd, curFar and answer, they only take constant space.

**/
public class JumpGameTwo {
	public int jump(int[] nums) {
		if(nums.length == 1) {
		    return 0;
		}
		int currIndex = 0;
		int jumps = 0;
		while (nums[currIndex] != 0) {
		    int maxJump = 0;
		    int maxIndex = 0;
		    for (int i = 1; i <= nums[currIndex]; ++i) {
			if (currIndex + i >= nums.length - 1) {
			    return ++jumps;
			}

			if (maxJump <= i + nums[currIndex + i]) {
			    maxJump = i + nums[currIndex + i];
			    maxIndex = currIndex + i;
			}
		    }
		    currIndex = maxIndex;
		    ++jumps;
		}

		return jumps;
	}

	public int jump(int[] nums) {
		int jumps = 0;
		int currEnd = 0;
		int currFar = 0;
		for(int i = 0; i < nums.length - 1; ++i) {
			currFar = Math.max(currFar, i + nums[i]);

			if(i == currEnd) {
				++jumps;
				currEnd = currFar;
			}
		}

		return jumps;
	}
}
