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
    private int target; 
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.target = target;
        root = deleteLeaf(root);
        return root;
    }

    private TreeNode deleteLeaf(TreeNode cur) {        
        if (cur == null) return null;
        cur.left = deleteLeaf(cur.left);
        cur.right = deleteLeaf(cur.right);
        if (cur.left == null && cur.right == null && cur.val == target) return null;
        return cur;
    }
}