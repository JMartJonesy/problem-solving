/**
637. Average of Levels in Binary Tree
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
**/
public class AverageOfLevelsInBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> answer = new ArrayList<>();
		if(root == null) {
			return new ArrayList<Double>();
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			double average = 0;
			for(int i = 0; i < qSize; ++i) {
				TreeNode top = queue.poll();
				average += top.val;
				if(top.left != null) {
					queue.offer(top.left);
				}
				if(top.right != null) {
					queue.offer(top.right);
				}
			}
			answer.add(average/qSize);
		}

		return answer;
	}
}
