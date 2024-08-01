/*
162. Find Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

*/
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int n = nums.length;
		int index = 0;
		while (index < n) {
			boolean biggerThanPrevious = true;
			if (index - 1 >= 0) {
				biggerThanPrevious = nums[index - 1] < nums[index];
			}

			boolean biggerThanNext = true;
			if (index + 1 < n) {
				biggerThanNext = nums[index + 1] < nums[index];
			}

			if (biggerThanPrevious && biggerThanNext) {
				return index;
			}

			if (biggerThanNext) {
				index += 2;
			} else {
				++index;
			}
		}

		return -1;
	}

	public int findPeakElementBinarySearch(int[] nums) {
		int l = 0;
		int r = nums.length - 1;

		while (l < r) {
			int mid = l + (r - l) / 2;
			int curr = nums[mid];
			if (mid + 1 >= nums.length || curr > nums[mid + 1]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return l;
	}
}
