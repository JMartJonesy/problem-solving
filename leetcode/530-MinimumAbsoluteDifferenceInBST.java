/**
530. Minimum Absolute Difference in BST
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
**/
public class MinimumAbsoluteDifferenceInBST {
	public int getMinimumDifference(TreeNode root) {
		List<Integer> vals = new ArrayList<>();
		populateVals(root, vals);
		int min = Integer.MAX_VALUE;
		for(int i = 1; i < vals.size(); ++i) {
			min = Math.min(min, Math.abs(vals.get(i) - vals.get(i-1)));
		}

		return min;
	}

	private void populateVals(TreeNode root, List<Integer> vals) {
		if(root != null) {
			populateVals(root.left, vals);
			vals.add(root.val);
			populateVals(root.right, vals);
		}
	}
}
