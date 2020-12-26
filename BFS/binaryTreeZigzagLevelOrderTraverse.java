/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean fromLeft = true;
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            // appending order depend on fromLeft
            for (int i = 0; i < size; i ++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            if (fromLeft) {
                result.add(level);
            } else {
                Collections.reverse(level);
                result.add(level);
            }
            fromLeft = !fromLeft;
        }
        return result;
    }
}