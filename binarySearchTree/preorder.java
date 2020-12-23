public class Solution {
	// 1.递归的定义：返回以root为根的二叉树的preorder
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}

	private void traverse(TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}

		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right, result);
	}
}

// iterate version
public class Solution {
	public List<Integer> preorderTraversal(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> preorder = new ArrayList<Integer>();

		if (root == null) {
			return preorder;
		}

		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}

		return preorder;
	}
}