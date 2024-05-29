/**
  129. Sum Root to Leaf Numbers
You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.

Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
**/

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return sum(new StringBuilder(), root);
	}

	private int sum(StringBuilder curr, TreeNode node) {
		int total = 0;
		if(node == null) {
			return total;
		} else if(node.left == null && node.right == null) {
			curr.append(node.val);
			total = Integer.parseInt(curr.toString());
		} else {
			curr.append(node.val);
			total = sum(curr, node.left) + sum(curr, node.right);
		}

		curr.deleteCharAt(curr.length() - 1);

		return total;
	}
}
