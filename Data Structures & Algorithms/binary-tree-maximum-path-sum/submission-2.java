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
    private int max;
    private Map<TreeNode, Integer> memo;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        memo = new HashMap<>();
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0, maxPath(node.right));

        max = Math.max(max, node.val + left + right);
        
        memo.put(node, node.val + Math.max(left, right));
        return memo.get(node);
    }
}
