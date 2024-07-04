/**
101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
**/
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}

		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}

		if(left == null || right == null) {
			return false;
		}

		if(left.val != right.val) {
			return false;
		}

		return helper(left.left, right.right) && helper(left.right, right.left);
	}

}
