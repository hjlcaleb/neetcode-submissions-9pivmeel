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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    public int countGoodNodes(TreeNode node, int maxVal) {
        if (node == null) return 0;
        if (maxVal > node.val) {
            return 0 
                + countGoodNodes(node.left, Math.max(maxVal, node.val)) 
                + countGoodNodes(node.right, Math.max(maxVal, node.val));
        }
        return 1 
            + countGoodNodes(node.left, Math.max(maxVal, node.val)) 
            + countGoodNodes(node.right, Math.max(maxVal, node.val));
    }
}
