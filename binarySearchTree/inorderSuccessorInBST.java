// my version
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        
        if (p.right != null) {
            TreeNode current = p.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            TreeNode result = null;
            TreeNode current = root;
            // find p, check if any value larger than p
            while (current.val != p.val) {
                if (current.val < p.val) {
                    current = current.right;
                } else {
                    result = current;
                    current = current.left;
                }
            }
            return result;
        }
        
    }
}

// another version
public class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode successor = null;
		while (root != null && root.val != p.val) {
			if (root.val > p.val) {
				successor = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}

		if (root == null) {
			return null;
		}

		if (root.right == null) {
			return successor;
		}

		root = root.right;
		while (root.left != null) {
			root = root.left;
		}

		return root;
	}
}


// recursion version
public  class Solution {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) {
			return null;
		} 

		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		} else {
			TreeNode left = inorderSuccessor(root.left, p);
			return (left != null) ? left : root;
		}
	}
}