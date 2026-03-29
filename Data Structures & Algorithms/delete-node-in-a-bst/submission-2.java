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
    public TreeNode deleteNode(TreeNode root, int key) {
        root = dfs(root, key);
        return root;
    }

    private TreeNode dfs(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        
        if (node.val < key) {
            node.right = dfs(node.right, key);
        } else if (node.val > key) {
            node.left = dfs(node.left, key);
        } else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            TreeNode curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            curr.left = node.left;
            node = node.right;
        }
        return node;
    }
}