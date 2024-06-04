/**
104. Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
**/
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		return helper(root, 0);
	}

	private int helper(TreeNode node, int count) {
		if(node == null) {
			return count;
		}

		return Math.max(helper(node.left, count + 1), helper(node.right, count + 1));
	}
}
