class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<>();

		if (root == null) {
			return results;
		}

		// 1. create a queue and push the root in
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		// 2. create a while loop if the queue is not empty
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				} 
				if (node.right != null) {
					queue.offer(node.right);
				}
			}

			results.add(level);
		}

		return results;
	}
}