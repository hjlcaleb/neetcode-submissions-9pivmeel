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
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        exploreInorder(root);
        return result;
    }

    private void exploreInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        exploreInorder(node.left);
        result.add(node.val);
        exploreInorder(node.right);
    }
}