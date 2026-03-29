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
    private int count;
    private int k;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        this.k = k;
        result = -1;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        dfs(node.right);
    }
}
