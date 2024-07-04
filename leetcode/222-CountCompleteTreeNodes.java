/**
222. Count Complete Tree Nodes
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.
**/
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int lh = findLeftHeight(root.);
		int rh = findRightHeight(root);

		if(lh == rh) {
			return ((2 << (lh)) - 1);
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}

	private int findLeftHeight(TreeNode root) {
		int height = 0;
		while(root.left != null) {
			height++;
			root = root.left;
		}

		return height;
	}

	private int findRightHeight(TreeNode root) {
		int height = 0;
		while(root.right != null) {
			height++;
			root = root.right;
		}

		return height;
	}
}
