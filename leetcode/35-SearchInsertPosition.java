/**
35. Search Insert Position
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
**/
public class SearchInputPosition {
	public int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while(l <= r) {
			int middle = left + (r - l) / 2;
			if(nums[middle] == target) {
				return middle;
			} else if(nums[middle] < target) {
				l = middle + 1;
			} else {
				r = middle - 1;
			}
		}
		
		return l;
	}
}
