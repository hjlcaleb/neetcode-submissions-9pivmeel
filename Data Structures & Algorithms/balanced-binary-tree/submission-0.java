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
    public boolean isBalanced(TreeNode root) {
        return height(root)[0] == 1;
    }

    private int[] height(TreeNode node) {
        if (node == null) return new int[]{1, 0};

        int[] left = height(node.left);
        int[] right = height(node.right);

        boolean balanced = (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);

        if (balanced) {
            return new int[]{1, height};
        } 
        
        return new int[]{0, height};

    }
}
