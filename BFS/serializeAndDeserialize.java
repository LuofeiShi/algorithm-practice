/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // corner case 
        if (root == null) {
            return "{}";
        }
        
        // bfs traverse the Tree
        StringBuilder sb = new StringBuilder("{");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head == null) {
                    sb.append("#,");
                } else {
                    sb.append(head.val);
                    sb.append(",");
                }
                if (head != null) {
                    queue.offer(head.left);
                    queue.offer(head.right);
                }
            }
        }
        
        // delete extra null value
        while (sb.charAt(sb.length() - 1) == '#') {
            sb.deleteCharAt(sb.length() - 1);    // delete "#"
            sb.deleteCharAt(sb.length() - 1);    // delete ","
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        // Creating the tree by level order
        String content = data.substring(1, data.length() - 1);
        String[] values = content.split(",");
        int n = values.length;
        TreeNode[] nodes = new TreeNode[n];
        
        for (int i = 0; i < n; i++) {
            if ("#".equals(values[i])) {
                continue;
            }
            nodes[i] = new TreeNode(Integer.valueOf(values[i]));
        }
        
        int skip = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i] == null) {
                // each skip will skip 2 nodes (left and right);
                skip++;
                continue;
            }
            
            int leftIndex = i * 2 + 1 - skip * 2;
            if (leftIndex < n) {
                nodes[i].left = nodes[leftIndex];
            }
            
            int rightIndex = i * 2 + 2 - skip * 2;
            if (rightIndex < n) {
                nodes[i].right = nodes[rightIndex];
            }
        }
        return nodes[0];
    }
}