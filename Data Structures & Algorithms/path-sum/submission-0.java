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
    private int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode node, int curTotal) {
        if (node == null) return false;
        curTotal += node.val;
        return dfs(node.left, curTotal) 
            || dfs(node.right, curTotal) 
            || (curTotal == targetSum && node.left == null && node.right == null);
    }
}