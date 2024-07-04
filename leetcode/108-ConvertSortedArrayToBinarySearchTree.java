/**
108. Convert Sorted Array to Binary Search Tree
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
binary search tree.
**/
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return generateTree(nums, 0, nums.length - 1);
	}

	private TreeNode generateTree(int[] nums, int l, int r) {
		if(l > r) {
			return null;
		}

		int middle = (l + r) / 2;
		TreeNode root = new TreeNode(
			nums[middle],
			generateTree(nums, l, middle - 1),
			generateTree(nums, middle + 1, r)
		);

		return root;
	}
}
