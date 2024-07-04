/**
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
**/
public class TrappingRainWater {
	public int trap(int[] height) {
		int totalTrappedWater = 0;
		int trappedWater;
		int currWater;
		boolean countWater;
		int startIndex = 0;
		int endIndex = height.length - 1;
		do {
			trappedWater = 0;
			currWater = 0;
			countWater = false;
			int currEndIndex = endIndex;
			for(int i = 0; i <=currEndIndex; ++i) {
				if(height[i] > 0) {
					if(!countWater){
						startIndex = i;
						countWater = true;
					}
					trappedWater += currWater;
					currWater = 0;
					endIndex = i;
				}

				if(height[i] <= 0 && countWater) {
					currWater += 1;
				}
				--height[i];
			}
			totalTrappedWater += trappedWater;
		} while(countWater);

		return totalTrappedWater;
	}

	public int trapDP(int[] height) {
		int[][] dp = new int[2][height.length];
		dp[0][0] = 0;
		for(int i = 1; i < height.length; ++i) {
			dp[0][i] = Math.max(height[i - 1], dp[0][i - 1];
		}

		dp[1][height.length - 1] = 0;
		for(int i = height.length - 2; i >= 0; --i) {
			dp[1][i] = Math.max(height[i + 1], dp[1][i + 1];
		}

		int trappedWater = 0;
		for(int i = 0; i < height.length; ++i) {
			int curr = Math.min(dp[0][i], dp[1][i]) - height[i];
			if(curr > 0) {
				trappedWater += curr
			}
		}

		return trappedWater;
	}

	public int trapTwoPointers(int[] height) {
		int trappedWater = 0;

		int lMax = 0;
		int rMax = 0;
		int l = 0;
		int r = height.length - 1;
		while(l < r) {
			if(height[l] < height[r]) {
				lMax = Math.max(lMax, height[l]);
				trappedWater += lMax - height[l];
				++l;
			} else {
				rMax = Math.max(rMax, height[r]);
				trappedWater += rMax - height[r];
				--r;
			}
		}

		return trappedWater;
	}
}
