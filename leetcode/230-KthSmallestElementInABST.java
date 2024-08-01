import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * Given the root of a binary search tree, and an integer k, return the kth
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 */
public class KthSmallestElementInABST {

	public class TreeNode {
		int val;
		TreeNode left;

		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> nums = new ArrayList<>();

		helper(root, k, nums);
		return nums.get(k - 1);
	}

	private void helper(TreeNode root, int k, List<Integer> nums) {
		if (nums.size() != k) {
			if (root.left != null) {
				helper(root.left, k, nums);
			}
			nums.add(root.val);
			if (root.right != null) {
				helper(root.right, k, nums);
			}
		}
	}
}
