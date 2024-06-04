/**
228. Summary Ranges
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b
**/
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> answer = new ArrayList<>();
		int a = 0;
		int b = 0;
		StringBuilder range = new StringBuilder();
		while(b < nums.length) {
			if((b + 1) == nums.length || (nums[b + 1] - nums[b] != 1)) {
				range.append(nums[a]);
				if(a != b) {
					range.append("->");
					range.append(nums[b]);
				}
				answer.add(range.toString());
				range.setLength(0);
				a = b + 1;
			}
			b = b + 1;
		}

		return answer;
	}
}
