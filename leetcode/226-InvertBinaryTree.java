/**
226. Invert Binary Tree
Given the root of a binary tree, invert the tree, and return its root.
**/
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root != null) {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			invertTree(root.left);
			invertTree(root.right);
		}

		return root;
	}
}
