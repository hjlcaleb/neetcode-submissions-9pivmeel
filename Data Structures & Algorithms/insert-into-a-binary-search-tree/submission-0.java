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
    private int val;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        this.val = val;
        return insert(root);
    }

    private TreeNode insert(TreeNode node) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val > node.val) {
            node.right = insert(node.right);
        } else {
            node.left = insert(node.left);
        }
        return node;
    }
}