/**
169. Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
**/
public class MajorityElement {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> counts = new HashMap<>();
		int threshold = (nums.length/2)+1;
		int maxNum = 0;
		int maxCount = 0;
		for(int i: nums) {
			int newCount = counts.getOrDefault(i, 0) + 1;
			counts.put(i, newCount);
			if(newCount == threshold) {
				return i;
			}
			if(maxCount < newCount) {
				maxNum = i;
			}
		}

		return maxNum;
	}
}
