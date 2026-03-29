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
    private List<Integer> result; 

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        explorePostorder(root);
        return result;
    }

    private void explorePostorder(TreeNode node) {
        if (node == null) return;
        explorePostorder(node.left);
        explorePostorder(node.right);
        result.add(node.val);
    }
}