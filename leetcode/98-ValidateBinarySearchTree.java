/**
 * 98. Validate Binary Search Tree
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * The left
 * subtree
 * of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 */
public class ValidateBinarySearchTree {
	private Integer prev;
	public boolean isValidBST(TreeNode root) {
		prev = null;
		return inOrder(root);
	}

	private boolean inOrder(TreeNode root) {
		if (root == null) {
			return true;
		}

		if(!inOrder(root.left)) {
			return false;
		}

		if (prev != null && prev >= root.val) {
			return false;
		}

		prev = root.val;

		return inOrder(root.right);
	}

}
