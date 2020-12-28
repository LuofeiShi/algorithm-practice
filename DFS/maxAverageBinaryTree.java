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
    private double maxAverage = Integer.MIN_VALUE;
    private TreeNode result = null;
    
    private class returnType {
        private int size;
        private int sum;

        private returnType(int size, int sum) {
            this.size = size;
            this.sum = sum;
        }
        
        private double getAvg() {
            double average;
            if (this.size != 0) {
                average = (double)sum / (double)size;
            } else {
                average = 0;
            }
            return average;
        }
        
        private int getSize() {
            return this.size;
        }
        
        private int getSum() {
            return this.sum;
        }
    }
    
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        helper(root);
        
        return result;
    }
    
    private returnType helper(TreeNode root) {
        if (root == null) {
            return new returnType(0, 0);
        }
        
        returnType left = helper(root.left);
        returnType right = helper(root.right);
        returnType current = new returnType(left.getSize() + right.getSize() + 1, left.getSum() + right.getSum() + root.val);
        System.out.println("a:" + current.getSize() + current.getSum() + current.getAvg() );
        if (current.getAvg() > this.maxAverage ) {
            result = root;
            maxAverage = current.getAvg();
        }
        return current;
    }
    
}